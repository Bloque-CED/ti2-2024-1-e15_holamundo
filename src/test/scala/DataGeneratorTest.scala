import munit.FunSuite

class DataGeneratorTest extends FunSuite {
  
  // Las entradas están categorizadas de acuerdo a su tamaño así: 
  //Toy, n<10^2  set value = 99
  //Small, 10^2<=n<10^4 set value = 9999
  //Medium, 10^4<=n<10^5 set value = 99999
  //Large, n<10^6 set value = 1000000
  
  val dataGenerator = new data.DataGenerator()
  val dataLoader = new data.DataLoader()
  
  test("Generate data file with Toy size") {
    dataGenerator.generateData("ToyData", "Toy")
    val data = dataLoader.loadData("src/main/resources/data/ToyData.txt")
    assert(data.length == 99)
  }
  
  test("Generate data file with Small size") {
    dataGenerator.generateData("SmallData", "Small")
    val data = dataLoader.loadData("src/main/resources/data/SmallData.txt")
    assert(data.length == 9999)
  }
 
  test("Generate data file with Medium size") {
    dataGenerator.generateData("MediumData", "Medium")
    val data = dataLoader.loadData("src/main/resources/data/MediumData.txt")
    assert(data.length == 99999)
  }

  test("Generate data file with Large size") {
    dataGenerator.generateData("LargeData", "Large")
    val data = dataLoader.loadData("src/main/resources/data/LargeData.txt")
    assert(data.length == 1000000)
  }
 
  test("Generate data file with specified length") {
    dataGenerator.generateData("SpecifiedData", 100)
    val data = dataLoader.loadData("src/main/resources/data/SpecifiedData.txt")
    assert(data.length == 100)
  }
}
