package data

class DataLoader {
  
  /**
   * Load data from a file
   * @param path the path to the file
   * @return the data in the file
   */
  def loadData(path : String): String = {
    val source = scala.io.Source.fromFile(path)
    val lines = try source.mkString finally source.close()
    lines
  }
}
