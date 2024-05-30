package data
import java.io.{FileOutputStream, OutputStreamWriter, BufferedWriter, File}
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

class DataWriter {

  // Escribe datos binarios a un archivo
  def writeBinaryData(filePath: String, data: Array[Byte]): Unit = {
    val outputStream = new FileOutputStream(filePath)
    try {
      outputStream.write(data)
    } finally {
      outputStream.close()
    }
  }

  // Escribe datos de texto a un archivo
  def writeTextData(filePath: String, data: String): Unit = {
    val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))
    try {
      writer.write(data)
    } finally {
      writer.close()
    }
  }

  // Añade texto a un archivo existente, para usar en la acumulación de resultados
  def appendTextData(filePath: String, data: String): Unit = {
    val writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND)
    try {
      writer.write(data)
      writer.newLine() // Añade una nueva línea para separar los registros
    } finally {
      writer.close()
    }
  }


}
