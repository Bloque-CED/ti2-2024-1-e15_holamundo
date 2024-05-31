package algorithms

class CheckSumCalculator {

  def calculate(data: Array[Byte]): Int = {
    data.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
  }

  def calculateChecksum(data: String): Int = {
    calculate(data.getBytes)
  }
}



