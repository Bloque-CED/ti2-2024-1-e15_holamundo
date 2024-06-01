import munit.FunSuite
import data.DataGenerator

/**
 * The DataGeneratorTest class contains unit tests for the DataGenerator class.
 */
class  DataGeneratorTest extends FunSuite {

  val dataGenerator = new DataGenerator()


  /**
   * Tests the generation of a byte array with a specific size.
   */
  test("Generate byte array with specific size") {
    val size = 50
    val data = dataGenerator.generateData(size)
    assert(data.length == size, "The generated data should have the exact size")
  }

  /**
   * Tests the generation of a random string within a specified size range.
   */
  test("Generate random string within size range") {
    val minSize = 10
    val maxSize = 100
    val randomString = dataGenerator.generateString(minSize, maxSize)
    assert(randomString.length >= minSize && randomString.length <= maxSize, "String should be within the specified size range")
  }

  /**
   * Tests the generation of string data for each category.
   */
  test("Generate string data for each category") {
    List("Toy", "Small", "Medium", "Large").foreach { category =>
      val data = dataGenerator.generateStringData(category)
      val sizes = dataGenerator.chooseSizeRange(category)
      assert(data.length >= sizes._1 && data.length <= sizes._2, s"Generated string data for $category should be within size range")
    }
  }

}


