package algorithms

/**
 * The CRCCalculator class provides methods to calculate and verify CRC checksums for data integrity.
 */
class CRCCalculator {

  /**
   * Calculates the CRC checksum for a given string using a specified generator polynomial.
   *
   * @param data      the input data string for which the CRC checksum is to be calculated
   * @param generator the generator polynomial string used for the CRC calculation
   * @return the calculated CRC checksum as a string
   */
  def calculate(data: String, generator: String): String = {
    val k = generator.length
    val appendedData = data + "0" * (k - 1)
    var dividend = appendedData.substring(0, k)

    def xor(dividend: String, generator: String): String = {
      dividend.zip(generator).map { case (d, g) => if (d == g) '0' else '1' }.mkString
    }

    for (i <- k until appendedData.length) {
      if (dividend.head == '1') {
        dividend = xor(dividend, generator) + appendedData(i)
      } else {
        dividend = dividend.tail + appendedData(i)
      }
    }

    if (dividend.head == '1') xor(dividend, generator).substring(1)
    else dividend.substring(1)
  }

  /**
   * Verifies the integrity of the data using the provided CRC checksum and generator polynomial.
   *
   * @param data      the input data string whose CRC checksum needs to be verified
   * @param checksum  the CRC checksum to verify against
   * @param generator the generator polynomial string used for the CRC calculation
   * @return true if the calculated CRC checksum matches the provided checksum, false otherwise
   */
  def verify(data: String, checksum: String, generator: String): Boolean = {
    calculate(data + checksum, generator).forall(_ == '0')
  }

  /**
   * Calculates the CRC checksum for a given byte array using a specified generator polynomial.
   *
   * @param data      the input data byte array for which the CRC checksum is to be calculated
   * @param generator the generator polynomial byte array used for the CRC calculation
   * @return the calculated CRC checksum as a byte array
   */
  def calculateBytes(data: Array[Byte], generator: Array[Byte]): Array[Byte] = {
    val k = generator.length
    val appendedData = data ++ Array.fill[Byte](k - 1)(0)
    var dividend = appendedData.take(k)

    def xor(dividend: Array[Byte], generator: Array[Byte]): Array[Byte] = {
      dividend.zip(generator).map { case (d, g) => (d ^ g).toByte }
    }

    for (i <- k until appendedData.length) {
      if (dividend.head == 1) {
        dividend = xor(dividend, generator) ++ Array(appendedData(i))
      } else {
        dividend = dividend.tail ++ Array(appendedData(i))
      }
    }

    if (dividend.head == 1) xor(dividend, generator).tail
    else dividend.tail
  }

  /**
   * Verifies the integrity of the data using the provided CRC checksum and generator polynomial.
   *
   * @param data      the input data byte array whose CRC checksum needs to be verified
   * @param checksum  the CRC checksum byte array to verify against
   * @param generator the generator polynomial byte array used for the CRC calculation
   * @return true if the calculated CRC checksum matches the provided checksum, false otherwise
   */
  def verifyBytes(data: Array[Byte], checksum: Array[Byte], generator: Array[Byte]): Boolean = {
    calculateBytes(data ++ checksum, generator).forall(_ == 0)
  }
}
