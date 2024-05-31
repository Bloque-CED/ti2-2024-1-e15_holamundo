package data

class Conver {

  // Convertir una cadena a su representación binaria
  def stringToBinary(str: String): String = {
    str.flatMap(char => String.format("%8s", Integer.toBinaryString(char)).replace(' ', '0'))
  }

  // Convertir una cadena binaria a su representación de texto
  def binaryToString(binary: String): String = {
    binary.grouped(8).map(byte => Integer.parseInt(byte, 2).toChar).mkString
  }

  // Convertir una cadena a su representación ASCII
  def stringToAscii(inputString: String): String = {
    inputString.map(char => f"${char.toInt}%03d").mkString
  }

  // Convertir un número decimal a su representación hexadecimal
  def decimalToHex(decimal: Int): String = {
    decimal.toHexString.toUpperCase
  }
}
