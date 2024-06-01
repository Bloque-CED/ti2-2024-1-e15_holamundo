package data

import java.io.{File, PrintWriter}
import scala.collection.mutable.ArrayBuffer
import scala.io.Source


/**
 * The DataLoader class provides methods for loading and saving text files in a specified folder.
 *
 * @param dataFolderPath the path to the folder containing the data files
 */
class DataLoader(private val dataFolderPath: String) {


  /**
   * Loads the content of a specific text file from the data folder.
   *
   * @param fileName the name of the text file to load
   * @return an Option containing the content of the text file if it exists and is successfully loaded, None otherwise
   */
  // Método para cargar un archivo de texto específico en la carpeta dataLoad
  def loadTextFile(fileName: String): Option[String] = {
    val file = new File(s"$dataFolderPath/$fileName")

    if (file.exists() && file.getName.endsWith(".txt")) {
      try {
        val source = Source.fromFile(file)
        val content = source.getLines().mkString("\n")
        source.close()
        Some(content)
      } catch {
        case _: Throwable => None
      }
    } else {
      None
    }
  }


  /**
   * Loads the content of all text files in the data folder.
   *
   * @return an ArrayBuffer containing the content of all text files in the data folder
   */
  // Método para cargar todos los archivos de texto en la carpeta dataLoad
  def loadAllTextFiles(): ArrayBuffer[String] = {
    val files = new File(dataFolderPath).listFiles().filter(_.getName.endsWith(".txt"))
    val contentBuffer = ArrayBuffer[String]()

    for (file <- files) {
      try {
        val source = Source.fromFile(file)
        val content = source.getLines().mkString("\n")
        contentBuffer += content
        source.close()
      } catch {
        case _: Throwable =>
      }
    }

    contentBuffer
  }


  /**
   * Saves an array of strings to a text file.
   *
   * @param fileName the name of the text file to save
   * @param array    the array of strings to save to the text file
   */
  // Método para guardar un array de strings en un archivo de texto
  def saveToTextFile(fileName: String, array: Array[String]): Unit = {
    val file = new File(s"$dataFolderPath/$fileName")

    if (file.exists() && file.getName.endsWith(".txt")) {
      val pw = new PrintWriter(file)
      try {
        array.zipWithIndex.foreach { case (element, index) =>
          pw.println(s"$index $element")
        }
      } finally {
        pw.close()
      }
    }
  }
}
