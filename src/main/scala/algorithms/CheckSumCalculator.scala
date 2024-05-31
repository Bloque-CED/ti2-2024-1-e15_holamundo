package algorithms

class CheckSumCalculator {

  // Función para calcular el checksum de una secuencia de bytes
  def calculate(data: Array[Byte]): Int = {
    data.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
  }

  // Función para calcular el checksum de una cadena
  def calculateChecksum(data: String): Int = {
    calculate(data.getBytes)
  }

  // Función para verificar la integridad de los datos usando el checksum
  def verifyChecksumCalculate(data: Array[Byte], checksum: Int): Boolean = {
    calculate(data) == checksum
  }

  // Función para verificar la integridad de los datos en cadena usando el checksum
  def verifyChecksumCalculateChecksum(data: String, checksum: Int): Boolean = {
    calculateChecksum(data) == checksum
  }

}





