import algorithms.CRCCalculator
import munit.FunSuite

/**
 * The CRCTest class contains unit tests for the CRCCalculator class.
 */
class CRCTest extends FunSuite {

  val calculator = new CRCCalculator

  /**
   * Tests the CRC calculation for a given data string and generator polynomial.
   */
  test("CRC calculation for '10101010' with generator '1101'") {
    val data = "10101010"
    val generator = "1101"
    val expectedCRC = "100"
    assertEquals(calculator.calculate(data, generator), expectedCRC)
  }

  /**
   * Tests the CRC calculation for another data string and generator polynomial.
   */
  test("CRC calculation for '11110000' with generator '1011'") {
    val data = "11110000"
    val generator = "1011"
    val expectedCRC = "001"
    assertEquals(calculator.calculate(data, generator), expectedCRC)
  }

  /**
   * Tests the CRC verification for a given data string, CRC, and generator polynomial.
   */
  test("CRC verification for '10101010' with CRC '100' and generator '1101'") {
    val data = "10101010"
    val generator = "1101"
    val crc = "100"
    assert(calculator.verify(data, crc, generator))
  }

  /**
   * Tests the CRC verification for another data string, CRC, and generator polynomial.
   */
  test("CRC verification for '11110000' with CRC '001' and generator '1011'") {
    val data = "11110000"
    val generator = "1011"
    val crc = "001"
    assert(calculator.verify(data, crc, generator))
  }

  /**
   * Tests the CRC calculation for a given byte array and generator polynomial.
   */
  test("CRC calculation for byte array [1, 2, 3, 4] with generator [1, 0, 1, 1]") {
    val data: Array[Byte] = Array(1, 2, 3, 4)
    val generator: Array[Byte] = Array(1, 0, 1, 1)
    val expectedCRC: Array[Byte] = Array(0, 1, 0) // Ajustado según el cálculo esperado
    assert(calculator.calculateBytes(data, generator).sameElements(expectedCRC))
  }

  /**
   * Tests the CRC verification for a given byte array, CRC, and generator polynomial.
   */
  test("CRC verification for byte array [1, 2, 3, 4] with CRC [0, 1, 0] and generator [1, 0, 1, 1]") {
    val data: Array[Byte] = Array(1, 2, 3, 4)
    val generator: Array[Byte] = Array(1, 0, 1, 1)
    val crc: Array[Byte] = Array(0, 1, 0)
    assert(calculator.verifyBytes(data, crc, generator))
  }

  /**
   * Test to verify the consistency of CRC calculation for the same input data and generator.
   */
  test("CRC calculation consistency for same input data and generator") {
    val data = "11110000"
    val generator = "1011"
    val result1 = calculator.calculate(data, generator)
    val result2 = calculator.calculate(data, generator)
    assertEquals(result1, result2)
  }

  /**
   * Test to verify the consistency of CRC calculation for the same input data and generator as byte arrays.
   */
  test("CRC byte array calculation consistency for same input data and generator") {
    val data: Array[Byte] = Array(1, 2, 3, 4)
    val generator: Array[Byte] = Array(1, 0, 1, 1)
    val result1 = calculator.calculateBytes(data, generator)
    val result2 = calculator.calculateBytes(data, generator)
    assert(result1.sameElements(result2))
  }
}
