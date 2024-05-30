package data

import java.nio.file.{Paths, Files}


class DataLoader {

  // Carga datos binarios directamente desde un archivo
  def load(filePath: String): Array[Byte] = {
    Files.readAllBytes(Paths.get(filePath))
  }

  // Carga datos de texto desde un archivo y los devuelve directamente como bytes
  def readFromMemory(data: Array[Byte]): Array[Byte] = {
    data.clone()
  }
}