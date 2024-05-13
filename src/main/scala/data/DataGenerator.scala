package data

class DataGenerator {

  private val Toy = 99
  private val Small = 9999
  private val Medium = 99999
  private val Large = 1000000
  
  def generateData(length: Int): String = {
    val r = new scala.util.Random
    (1 to length).map(_ => r.nextInt(256).toChar).mkString
  }
  
  def generateData(category: String): String = {
    category match {
      case "Toy" => generateData(Toy)
      case "Small" => generateData(Small)
      case "Medium" => generateData(Medium)
      case "Large" => generateData(Large)
      case _ => ""
    }
  }
}
