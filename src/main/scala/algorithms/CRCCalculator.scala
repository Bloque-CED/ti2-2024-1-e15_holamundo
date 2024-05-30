package algorithms

class CRCCalculator {

  def calculate(data: Array[Byte], polynomial: Int): Int = {
    var crc = 0xFFFFFFFF

    for (byte <- data) {
      crc ^= (byte & 0xFF) << 24
      for (_ <- 0 until 8) {
        if ((crc & 0x80000000) != 0) {
          crc = (crc << 1) ^ polynomial
        } else {
          crc <<= 1
        }
      }
    }

    crc ^ 0xFFFFFFFF
  }
}
