package data
import scala.util.Random

  class DataGenerator {
    def generateData(size: Int): Array[Byte] = {
      val data = new Array[Byte](size)
      Random.nextBytes(data)
      data
    }

    // Genera una cadena de caracteres con longitud variable dentro de un rango específico
    def generateString(minSize: Int, maxSize: Int): String = {
      val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
      val size = Random.nextInt(maxSize - minSize + 1) + minSize
      (1 to size).map(_ => source(Random.nextInt(source.length))).mkString
    }

    // Selecciona el tamaño del Array o String según las categorías
    def chooseSizeRange(category: String): (Int, Int) = {
      category match {
        case "Toy" => (1, 101) // n < 102
        case "Small" => (102, 9999) // 102 ≤ n < 10,000
        case "Medium" => (10000, 99999) // 10,000 ≤ n < 100,000
        case "Large" => (100000, 999999) // 100,000 ≤ n < 1,000,000
        case _ => throw new IllegalArgumentException("Invalid category size")
      }
    }

    // Genera una cadena de caracteres aleatoria según la categoría y la convierte a bytes
    def generateStringData(category: String): Array[Byte] = {
      val (minSize, maxSize) = chooseSizeRange(category)
      val randomString = generateString(minSize, maxSize)
      randomString.getBytes("UTF-8")
    }
  }

