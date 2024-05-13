import algorithms.CRCCalculator
import munit.FunSuite

class CRCTest extends FunSuite {
  val crcCalculator = new CRCCalculator()


  test("CRC should calculate the correct CRC for an empty string") {
    val polynomial = 0xB // x^3 + x + 1 = 1011
    val degree = 3

    assert(crcCalculator.calculate("", degree, polynomial) === 0x0)
  }

  test("CRC should calculate the correct CRC for a short string") {
    val polynomial = 0xB // x^3 + x + 1 = 1011
    val degree = 3
    val input = "hello"
    val expectedCRC = 0x6D

    assert(crcCalculator.calculate(input, degree, polynomial) === expectedCRC)
  }

  test("CRC should calculate the correct CRC for a long string") {
    val polynomial = 0x15 // x^4 + x^3 + 1 = 10101
    val degree = 4
    val input = "This is a very long string for testing CRC calculation."
    val expectedCRC = 0xE5

    assert(crcCalculator.calculate(input, degree, polynomial) === expectedCRC)
  }

  test("CRC should calculate the correct CRC for a low-degree polynomial") {
    val polynomial = 0x05 // x^2 + 1 = 101
    val degree = 2
    val input = "12345678"
    val expectedCRC = 0x6D

    assert(crcCalculator.calculate(input, degree, polynomial) === expectedCRC)
  }

  test("CRC should calculate the correct CRC for a high-degree polynomial") {
    val polynomial = 0x8301 // x^8 + x^7 + x^6 + x^4 + x^2 + 1 = 100000111
    val degree = 8
    val input = "This is another long string for testing CRC with a high-degree polynomial."
    val expectedCRC = 0x4F

    assert(crcCalculator.calculate(input, degree, polynomial) === expectedCRC)
  }

}