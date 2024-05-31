package data

import java.nio.file.{Paths, Files}

class DataLoader {

  def load(filePath: String): Array[Byte] = {
    Files.readAllBytes(Paths.get(filePath))
  }

  def readFromMemory(data: Array[Byte]): Array[Byte] = {
    data.clone()
  }
}
