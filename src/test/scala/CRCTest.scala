import algorithms.CRCCalculator
import munit.FunSuite

class CRCTest extends FunSuite {

  val calculator = new CRCCalculator

  test("calculate method should return correct CRC when polynomial is 0") {

    val testData = Array[Byte](0x01, 0x02, 0x03, 0x04)
    val polynomial = 0
    val expectedCRC = 0xFFFFFFFF // Ajustado al valor correcto

    val result = calculator.calculate(testData, polynomial)

    assert(result == expectedCRC, s"Expected $expectedCRC but got $result")
  }

  test("calculate method should return same CRC for same input data and polynomial") {

    val testData1 = Array[Byte](0x01, 0x02, 0x03, 0x04)
    val testData2 = Array[Byte](0x01, 0x02, 0x03, 0x04)
    val polynomial = 0x04C11DB7

    val result1 = calculator.calculate(testData1, polynomial)
    val result2 = calculator.calculate(testData2, polynomial)

    assert(result1 == result2, s"Expected $result1 but got $result2")
  }
}
