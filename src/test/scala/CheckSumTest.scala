import munit.FunSuite

class CheckSumTest extends FunSuite {
  val checkSumCalculator = new SimpleCheckSumCalculator()

  test("Checksum of an empty string should be 0") {
    assertEquals(checkSumCalculator.calculateChecksum(""), 0)
  }

  test("Checksum of a single character 'a'") {
    assertEquals(checkSumCalculator.calculateChecksum("a"), 'a'.toInt)
  }

  test("Checksum of a short string 'hello'") {
    val expectedChecksum = "hello".map(_.toInt).sum
    assertEquals(checkSumCalculator.calculateChecksum("hello"), expectedChecksum)
  }

  test("Checksum of a long string") {
    val longString = "a" * 1000  // 1000 characters of 'a'
    val expectedChecksum = longString.map(_.toInt).sum
    assertEquals(checkSumCalculator.calculateChecksum(longString), expectedChecksum)
  }

  test("Checksum of a string with special characters '!@#$%^&*()_+'") {
    val specialChars = "!@#$%^&*()_+"
    val expectedChecksum = specialChars.map(_.toInt).sum
    assertEquals(checkSumCalculator.calculateChecksum(specialChars), expectedChecksum)
  }

  test("Checksum of a string containing numbers '123456789'") {
    val numbers = "123456789"
    val expectedChecksum = numbers.map(_.toInt).sum
    assertEquals(checkSumCalculator.calculateChecksum(numbers), expectedChecksum)
  }
  
}
