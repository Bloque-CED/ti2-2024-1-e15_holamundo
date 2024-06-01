package algorithms

/**
 * The CheckSumCalculator class provides methods to calculate and verify checksums for data integrity.
 */
class CheckSumCalculator {

  /**
   * Calculates the checksum of a sequence of bytes.
   *
   * @param data the byte array for which the checksum is to be calculated
   * @return the calculated checksum as an integer
   */
  // Función para calcular el checksum de una secuencia de bytes
  def calculate(data: Array[Byte]): Int = {
    data.foldLeft(0)((checksum, byte) => checksum + (byte & 0xFF)) & 0xFF
  }

  /**
   * Calculates the checksum of a string.
   *
   * @param data the string for which the checksum is to be calculated
   * @return the calculated checksum as an integer
   */
  // Función para calcular el checksum de una cadena
  def calculateChecksum(data: String): Int = {
    calculate(data.getBytes)
  }

  /**
   * Verifies the integrity of the data using the provided checksum.
   *
   * @param data     the byte array whose checksum needs to be verified
   * @param checksum the checksum to verify against
   * @return true if the calculated checksum matches the provided checksum, false otherwise
   */
  // Función para verificar la integridad de los datos usando el checksum
  def verifyChecksumCalculate(data: Array[Byte], checksum: Int): Boolean = {
    calculate(data) == checksum
  }

  /**
   * Verifies the integrity of the string data using the provided checksum.
   *
   * @param data     the string whose checksum needs to be verified
   * @param checksum the checksum to verify against
   * @return true if the calculated checksum matches the provided checksum, false otherwise
   */
  // Función para verificar la integridad de los datos en cadena usando el checksum
  def verifyChecksumCalculateChecksum(data: String, checksum: Int): Boolean = {
    calculateChecksum(data) == checksum
  }

}





