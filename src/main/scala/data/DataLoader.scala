package data

import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets

class DataLoader {

  // Carga datos binarios directamente desde un archivo
  def loadBinaryData(filePath: String): Array[Byte] = {
    Files.readAllBytes(Paths.get(filePath))
  }

  // Carga datos de texto desde un archivo y los devuelve directamente como bytes
  def loadTextDataAsBytes(filePath: String): Array[Byte] = {
    Files.readAllBytes(Paths.get(filePath))
  }
}