import algorithms.CheckSumCalculator
import munit.FunSuite

class CheckSumTest extends FunSuite {
  val checkSumCalculator = new CheckSumCalculator()

  test("Checksum of an empty string should be 0") {
    assertEquals(checkSumCalculator.calculateChecksum(""), 0)
  }

  test("Checksum of a single character 'a'") {
    assertEquals(checkSumCalculator.calculateChecksum("a"), 'a'.toInt & 0xFF)
  }

  test("Checksum of a short string 'hello'") {
    val expectedChecksum = "hello".getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum("hello"), expectedChecksum)
  }

  test("Checksum of a long string") {
    val longString = "a" * 1000 // 1000 characters of 'a'
    val expectedChecksum = longString.getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum(longString), expectedChecksum)
  }

  test("Checksum of a string with special characters '!@#$%^&*()_+'") {
    val specialChars = "!@#$%^&*()_+"
    val expectedChecksum = specialChars.getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum(specialChars), expectedChecksum)
  }

  test("Checksum of a string containing numbers '123456789'") {
    val numbers = "123456789"
    val expectedChecksum = numbers.getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum(numbers), expectedChecksum)
  }
}
