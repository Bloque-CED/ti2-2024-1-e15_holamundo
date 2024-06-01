package data

/**
 * The Conver class provides methods for various conversions including string to binary,
 * binary to string, string to ASCII, and decimal to hexadecimal.
 */
class Conver {


  /**
   * Converts a string to its binary representation.
   *
   * @param str the input string to be converted to binary
   * @return a string representing the binary representation of the input string
   */
  // Convertir una cadena a su representación binaria
  def stringToBinary(str: String): String = {
    str.flatMap(char => String.format("%8s", Integer.toBinaryString(char)).replace(' ', '0'))
  }
  

  /**
   * Converts a binary string to its text representation.
   *
   * @param binary the binary string to be converted to text
   * @return a string representing the text representation of the input binary string
   */
  // Convertir una cadena binaria a su representación de texto
  def binaryToString(binary: String): String = {
    binary.grouped(8).map(byte => Integer.parseInt(byte, 2).toChar).mkString
  }

  /**
   * Converts a string to its ASCII representation.
   *
   * @param inputString the input string to be converted to ASCII
   * @return a string representing the ASCII representation of the input string
   */
  // Convertir una cadena a su representación ASCII
  def stringToAscii(inputString: String): String = {
    inputString.map(char => f"${char.toInt}%03d").mkString
  }

  /**
   * Converts a decimal number to its hexadecimal representation.
   *
   * @param decimal the decimal number to be converted to hexadecimal
   * @return a string representing the hexadecimal representation of the input decimal number
   */
  // Convertir un número decimal a su representación hexadecimal
  def decimalToHex(decimal: Int): String = {
    decimal.toHexString.toUpperCase
  }
}
