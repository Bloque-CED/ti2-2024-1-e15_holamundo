package data

import java.nio.file.{Paths, Files}
import algorithms.CheckSumCalculator
import data.Conver
import data.DataGenerator


class DataLoader {


  //def load(filePath: String): Array[Byte] = {
    //Files.readAllBytes(Paths.get(filePath))
  //}

 // def readFromMemory(data: Array[Byte]): Array[Byte] = {
   // data.clone()
 // }

 // def saveData(data: Array[Byte], filePath: String)(implicit spark: SparkSession): Unit = {
 //   spark.createDataFrame(Seq(("data", data))).write.format("binaryFile").save(filePath)
 // }

 // def loadAndCalculateChecksum(filePath: String, checksumCalculator: CheckSumCalculator): Int = {
 //   val data = load(filePath)
  //  checksumCalculator.calculateChecksum(new String(data))
  //}

 // def loadAndConvertData(filePath: String, converter: Conver): (String, Array[Byte], String) = {
 //   val data = load(filePath)
  //  val binaryData = converter.stringToBinary(new String(data))
   // val asciiData = converter.stringToAscii(new String(data))
  //  (binaryData, data, asciiData)
  //}

//  def generateAndSaveData(category: String, dataGenerator: DataGenerator, dataLoader: DataLoader, filePath: String): Unit = {
//    val data = dataGenerator.generateStringData(category)
  //  val dataString = new String(data)
  //  dataLoader.saveData(data, filePath)
  //  println(s"Data saved to $filePath: $dataString")
  //}
}