package data

class DataLoader {
  
  def loadData(path : String): String = {
    val source = scala.io.Source.fromFile(path)
    val lines = try source.mkString finally source.close()
    lines
  }
}
