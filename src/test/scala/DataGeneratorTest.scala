import munit.FunSuite
import data.DataGenerator

class  DataGeneratorTest extends FunSuite {

  val dataGenerator = new DataGenerator()

  test("Generate byte array with specific size") {
    val size = 50
    val data = dataGenerator.generateData(size)
    assert(data.length == size, "The generated data should have the exact size")
  }

  test("Generate random string within size range") {
    val minSize = 10
    val maxSize = 100
    val randomString = dataGenerator.generateString(minSize, maxSize)
    assert(randomString.length >= minSize && randomString.length <= maxSize, "String should be within the specified size range")
  }

  test("Generate string data for each category") {
    List("Toy", "Small", "Medium", "Large").foreach { category =>
      val data = dataGenerator.generateStringData(category)
      val sizes = dataGenerator.chooseSizeRange(category)
      assert(data.length >= sizes._1 && data.length <= sizes._2, s"Generated string data for $category should be within size range")
    }
  }

}


