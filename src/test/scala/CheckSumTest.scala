import algorithms.CheckSumCalculator
import munit.FunSuite

/**
 * The CheckSumTest class contains unit tests for the CheckSumCalculator class.
 */
class CheckSumTest extends FunSuite {
  val checkSumCalculator = new CheckSumCalculator()

  /**
   * Tests that the checksum of an empty string should be 0.
   */
  test("Checksum of an empty string should be 0") {
    assertEquals(checkSumCalculator.calculateChecksum(""), 0)
  }

  /**
   * Tests the checksum of a single character 'a'.
   */
  test("Checksum of a single character 'a'") {
    assertEquals(checkSumCalculator.calculateChecksum("a"), 'a'.toInt & 0xFF)
  }

  /**
   * Tests the checksum of a short string 'hello'.
   */
  test("Checksum of a short string 'hello'") {
    val expectedChecksum = "hello".getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum("hello"), expectedChecksum)
  }

  /**
   * Tests the checksum of a long string.
   */
  test("Checksum of a long string") {
    val longString = "a" * 1000 // 1000 characters of 'a'
    val expectedChecksum = longString.getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum(longString), expectedChecksum)
  }

  /**
   * Tests the checksum of a string with special characters '!@#$%^&*()_+'.
   */
  test("Checksum of a string with special characters '!@#$%^&*()_+'") {
    val specialChars = "!@#$%^&*()_+"
    val expectedChecksum = specialChars.getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum(specialChars), expectedChecksum)
  }

  /**
   * Tests the checksum of a string containing numbers '123456789'.
   */
  test("Checksum of a string containing numbers '123456789'") {
    val numbers = "123456789"
    val expectedChecksum = numbers.getBytes.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
    assertEquals(checkSumCalculator.calculateChecksum(numbers), expectedChecksum)
  }

  /**
   * Test to verify the verifyChecksumCalculateChecksum function for an empty string.
   */
  test("Verify checksum of an empty string") {
    val checksum = checkSumCalculator.calculateChecksum("")
    assert(checkSumCalculator.verifyChecksumCalculateChecksum("", checksum))
  }

  /**
   * Test to verify the verifyChecksumCalculateChecksum function for a single character 'a'.
   */
  test("Verify checksum of a single character 'a'") {
    val checksum = checkSumCalculator.calculateChecksum("a")
    assert(checkSumCalculator.verifyChecksumCalculateChecksum("a", checksum))
  }

  /**
   * Test to verify the verifyChecksumCalculateChecksum function for a short string 'hello'.
   */
  test("Verify checksum of a short string 'hello'") {
    val checksum = checkSumCalculator.calculateChecksum("hello")
    assert(checkSumCalculator.verifyChecksumCalculateChecksum("hello", checksum))
  }

  /**
   * Test to verify the verifyChecksumCalculateChecksum function for a long string.
   */
  test("Verify checksum of a long string") {
    val longString = "a" * 1000
    val checksum = checkSumCalculator.calculateChecksum(longString)
    assert(checkSumCalculator.verifyChecksumCalculateChecksum(longString, checksum))
  }

  /**
   * Test to verify the verifyChecksumCalculateChecksum function for a string with special characters '!@#$%^&*()_+'.
   */
  test("Verify checksum of a string with special characters '!@#$%^&*()_+'") {
    val specialChars = "!@#$%^&*()_+"
    val checksum = checkSumCalculator.calculateChecksum(specialChars)
    assert(checkSumCalculator.verifyChecksumCalculateChecksum(specialChars, checksum))
  }

  /**
   * Test to verify the verifyChecksumCalculateChecksum function for a string containing numbers '123456789'.
   */
  test("Verify checksum of a string containing numbers '123456789'") {
    val numbers = "123456789"
    val checksum = checkSumCalculator.calculateChecksum(numbers)
    assert(checkSumCalculator.verifyChecksumCalculateChecksum(numbers, checksum))
  }

  /**
   * Test to verify the verifyChecksumCalculate function for a byte array.
   */
  test("Verify checksum of a byte array") {
    val data: Array[Byte] = Array(1, 2, 3, 4, 5)
    val checksum = checkSumCalculator.calculate(data)
    assert(checkSumCalculator.verifyChecksumCalculate(data, checksum))
  }

  /**
   * Tests that the checksum of an empty byte array should be 0.
   */
  test("Checksum of an empty byte array should be 0") {
    assertEquals(checkSumCalculator.calculate(Array[Byte]()), 0)
  }
}
