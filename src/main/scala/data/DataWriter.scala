package data

class DataWriter {

  /**
   * Write data to a file
   * @param path the path to the file
   * @param data the data to write
   */
  def writeData(path: String, data: String): Unit = {
    import java.io._
    val pw = new PrintWriter(new File(path))
    pw.write(data)
    pw.close()
  }
}
