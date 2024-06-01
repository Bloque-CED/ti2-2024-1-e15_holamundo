package Main

import algorithms.*
import data.*
import java.io.FileWriter
import java.io.BufferedWriter
import scala.collection.mutable.ArrayBuffer

/**
 * The MainCRC object is responsible for generating data, calculating CRC checksums, and recording execution times.
 */
object MainCRC {

  /**
   * The main method that executes the CRC checksum generation and recording process.
   *
   * @param args the command-line arguments (not used)
   */
  def main(args: Array[String]): Unit = {
    
    // Initialize variables
    val categories = Array("Toy", "Small", "Medium", "Large") 
    val timeList = ArrayBuffer[Double]() 
    val startTime = System.currentTimeMillis() 

    
    // Create instances of necessary classes
    val crcCalculator = new CRCCalculator
    val dataGenerator = new DataGenerator
    val converter = new Conver
    val dataFolderPath = "dataLoad" 
    val dataLoader = new DataLoader(dataFolderPath)
    val executionTimer = new ExecutionTimer

    
    // Loop through each category and generate data
    categories.foreach(category => {
      // Generate data based on the category
      val data = dataGenerator.generateStringData(category)

      // Measure the time for the CRC calculation
      val (crc, executionTime) = executionTimer.measureTime(crcCalculator.calculate(new String(data), "1011")) 

      // Calculate the time difference
      val time = (System.currentTimeMillis() - startTime).toDouble / 1000

      // Add the time and checksum to their respective lists
      timeList += time
      println(s"Category: $category, CRC: $crc, Execution Time: $time milliseconds")

      // Save data to text file
      val fileName = s"$category.txt"
      dataLoader.saveToTextFile(fileName, Array(new String(data)))
    })

    // Save the time data to a file
    val fileWriter = new FileWriter("crc_times.txt")
    val bufferedWriter = new BufferedWriter(fileWriter)
    timeList.foreach(time => bufferedWriter.write(time.toString + "\n"))
    bufferedWriter.close()
  }
}
