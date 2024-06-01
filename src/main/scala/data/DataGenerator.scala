package data

import scala.util.Random

/**
 * The DataGenerator class provides methods to generate random data and strings of various sizes.
 */
class DataGenerator {


  /**
   * Generates an array of random bytes of the specified size.
   *
   * @param size the size of the byte array to generate
   * @return an array of random bytes of the specified size
   */
  def generateData(size: Int): Array[Byte] = {
    val data = new Array[Byte](size)
    Random.nextBytes(data)
    data
  }


  /**
   * Generates a random string with a length between the specified minimum and maximum sizes.
   *
   * @param minSize the minimum size of the generated string
   * @param maxSize the maximum size of the generated string
   * @return a random string with a length between minSize and maxSize
   */
  def generateString(minSize: Int, maxSize: Int): String = {
    val source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    val size = Random.nextInt(maxSize - minSize + 1) + minSize
    (1 to size).map(_ => source(Random.nextInt(source.length))).mkString
  }

  /**
   * Chooses a size range based on the specified category.
   *
   * @param category the category for which the size range is to be chosen
   * @return a tuple representing the minimum and maximum sizes for the specified category
   * @throws IllegalArgumentException if the category is invalid
   */
  def chooseSizeRange(category: String): (Int, Int) = {
    category match {
      case "Toy" => (1, 101)
      case "Small" => (102, 9999)
      case "Medium" => (10000, 99999)
      case "Large" => (100000, 999999)
      case _ => throw new IllegalArgumentException("Invalid category size")
    }
  }

  /**
   * Generates random string data for a specified category and converts it to a byte array.
   *
   * @param category the category for which the string data is to be generated
   * @return a byte array representing the random string data for the specified category
   * @throws IllegalArgumentException if the category is invalid
   */
  def generateStringData(category: String): Array[Byte] = {
     val (minSize, maxSize) = chooseSizeRange(category)
     val randomString = generateString(minSize, maxSize)
     randomString.getBytes("UTF-8")
  }

}




