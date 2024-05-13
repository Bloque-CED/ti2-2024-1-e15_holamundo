package data

class DataGenerator {

  // Constants for category sizes
  private final val Toy = 99
  private final val Small = 9999
  private final val Medium = 99999
  private final val Large = 1000000
  
  // Default path for data files
  private final val defaultPath = "src/main/resources/data/"
  
  // Data writer
  private final val writer = new DataWriter()

  /**
   * Generate data file with predetermined category size
   * @param name File name
   * @param category Category name
   */
  def generateData(name: String, category: String): Unit = {
    writer.writeData(defaultPath + name + ".txt", generate(category))
  }
  
  /**
   * Generate data file with specified length
   * @param name File name
   * @param length Length of the data
   */
  def generateData(name : String, length: Int): Unit = {
    writer.writeData(defaultPath + name + ".txt", generate(length))
  }

  /**
   * Generate string with random data of a given length
   * @param length Length of the data
   * @return Random data
   */
  private def generate(length: Int): String = {
    val r = new scala.util.Random
    (1 to length).map(_ => r.nextInt(256).toChar).mkString
  }

  /**
   * Generate string with random data of a given category length
   * @param category Category name
   * @return Random data
   */
  private def generate(category: String): String = {
    category match {
      case "Toy" => generate(Toy)
      case "Small" => generate(Small)
      case "Medium" => generate(Medium)
      case "Large" => generate(Large)
      case _ => ""
    }
  }
}
