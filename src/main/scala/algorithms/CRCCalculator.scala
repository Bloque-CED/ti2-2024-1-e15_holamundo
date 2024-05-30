package algorithms

class CRCCalculator {
  // Función para convertir una cadena de bits en un entero
  def bitsToInt(bits: String): Int = Integer.parseInt(bits, 2)

  // Función para convertir un entero a una cadena de bits con longitud fija
  def intToBits(value: Int, length: Int): String = {
    val bits = value.toBinaryString
    "0" * (length - bits.length) + bits
  }

  // Función para calcular el CRC
  def calculateCRC(data: String, polynomial: String): String = {
    val dataLength = data.length
    val polynomialLength = polynomial.length

    // Convertir los datos y el polinomio a enteros
    val dataInt = bitsToInt(data + "0" * (polynomialLength - 1))
    val polynomialInt = bitsToInt(polynomial)

    // Inicializar el divisor con los datos
    var divisor = dataInt

    // Realizar la división binaria de módulo 2
    for (i <- 0 until dataLength) {
      // Si el bit más significativo del divisor es 1, aplicar XOR con el polinomio
      if ((divisor & (1 << (dataLength + polynomialLength - 2 - i))) != 0) {
        divisor ^= (polynomialInt << (dataLength - 1 - i))
      }
    }

    // El resto es el CRC
    intToBits(divisor, polynomialLength - 1)
  }

  // Función principal para probar el algoritmo de CRC
  def main(args: Array[String]): Unit = {
    val data = "11010011101100"
    val polynomial = "1011"
    val crc = calculateCRC(data, polynomial)
    println(s"Data: $data")
    println(s"Polynomial: $polynomial")
    println(s"CRC: $crc")
  }
}
