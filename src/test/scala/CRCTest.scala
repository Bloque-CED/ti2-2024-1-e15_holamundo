import algorithms.CRCCalculator
import munit.FunSuite

class CRCTest extends FunSuite {
  val crcCalculator = new CRCCalculator()

  test("CRC should be zero for an empty string") {
    val data = ""
    val polynomial = "1011" // x^3 + x + 1
    assert(crcCalculator.calculateCRC(data, polynomial) == "000")
  }

  test("CRC for string of zeros") {
    val data = "00000000"
    val polynomial = "1001" // x^3 + 1
    assert(crcCalculator.calculateCRC(data, polynomial) == "000")
  }

  test("CRC for a simple string") {
    val data = "1101011011"
    val polynomial = "10011" // x^4 + x + 1
    assert(crcCalculator.calculateCRC(data, polynomial) == "0110")
  }

  test("CRC should handle leading and trailing zeros") {
    val data = "0011010110000"
    val polynomial = "1101" // x^3 + x^2 + 1
    assert(crcCalculator.calculateCRC(data, polynomial) == "010")
  }

  test("CRC for data longer than polynomial") {
    val data = "1101101011101010101"
    val polynomial = "101001" // x^5 + x^3 + 1
    assert(crcCalculator.calculateCRC(data, polynomial) == "01111")
  }

  test("CRC should return the same result for the same input multiple times") {
    val data = "1010101010"
    val polynomial = "110101" // x^5 + x^3 + x^2 + 1
    val result1 = crcCalculator.calculateCRC(data, polynomial)
    val result2 = crcCalculator.calculateCRC(data, polynomial)
    assert(result1 == result2)
  }

  test("CRC check for real-world application example") {
    val data = "1010100001110001"
    val polynomial = "10011" // x^4 + x + 1
    assert(crcCalculator.calculateCRC(data, polynomial) == "1101")
  }



}