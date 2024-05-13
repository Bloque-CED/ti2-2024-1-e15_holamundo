import munit.FunSuite

class DataGeneratorTest extends FunSuite {
  
  // Las entradas están categorizadas de acuerdo a su tamaño así: 
  //Toy, n<10^2
  //Small, 10^2<=n<10^4
  //Medium, 10^4<=n<10^5
  //Large, n<10^6
  
  test("DataGenerator should generate a string of length 99") {
    val dataGenerator = new DataGenerator()
    val generatedData = dataGenerator.generateData("Toy")
    assertEquals(generatedData.length, 99)
  }
  
  test("DataGenerator should generate a string of length 9999") {
    val dataGenerator = new DataGenerator()
    val generatedData = dataGenerator.generateData("Small")
    assertEquals(generatedData.length, 9999)
  }
  
  test("DataGenerator should generate a string of length 99999") {
    val dataGenerator = new DataGenerator()
    val generatedData = dataGenerator.generateData("Medium")
    assertEquals(generatedData.length, 99999)
  }
  
  test("DataGenerator should generate a string of length 999999") {
    val dataGenerator = new DataGenerator()
    val generatedData = dataGenerator.generateData("Large")
    assertEquals(generatedData.length, 9999999)
  }
  
  test("DataGenerator should generate an empty string for an invalid category") {
    val dataGenerator = new DataGenerator()
    val generatedData = dataGenerator.generateData("Invalid")
    assertEquals(generatedData.length, 0)
  }
  
  test("DataGenerator should generate an empty string for a negative length") {
    val dataGenerator = new DataGenerator()
    val length = -100
    val generatedData = dataGenerator.generateData(length)
    assertEquals(generatedData.length, 0)
  }
  
  test("DataGenerator should generate an empty string for a length of 0") {
    val dataGenerator = new DataGenerator()
    val length = 0
    val generatedData = dataGenerator.generateData(length)
    assertEquals(generatedData.length, 0)
  }
  
  test("DataGenerator should generate a string of arbitrary length") {
    val dataGenerator = new DataGenerator()
    val length = 12345
    val generatedData = dataGenerator.generateData(length)
    assertEquals(generatedData.length, length)
  }

}
