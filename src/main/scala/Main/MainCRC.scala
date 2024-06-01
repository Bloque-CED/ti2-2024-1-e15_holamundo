package Main

import algorithms._
import data._
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

    // Create instances of necessary classes
    val crcCalculator = new CRCCalculator
    val dataGenerator = new DataGenerator
    val dataFolderPath = "dataLoad"
    val dataLoader = new DataLoader(dataFolderPath)
    val executionTimer = new ExecutionTimer

    // Loop through each category and generate data
    categories.foreach(category => {
      // Initialize variables for each category
      val timeList = ArrayBuffer[Double]()
      val startTime = System.currentTimeMillis()

      // Generate data based on the category
      val data = dataGenerator.generateStringData(category)

      // Measure the time for the CRC calculation
      val (crc, executionTime) = executionTimer.measureTime {
        crcCalculator.calculate(new String(data), "1011") // Assuming CRC-4 with polynomial x^3 + x + 1
      }

      // Calculate the time difference
      val time = executionTime.toDouble / 1000

      // Print category, CRC, and execution time
      println(s"Category: $category, CRC: $crc, Execution Time: $time milliseconds")

      // Save data to text file
      val fileName = s"$category.txt"
      dataLoader.saveToTextFile(fileName, Array(new String(data)))

      // Save the time data to a file
      val fileWriter = new FileWriter(s"${category}_crc_times.txt")
      val bufferedWriter = new BufferedWriter(fileWriter)
      bufferedWriter.write(time.toString)
      bufferedWriter.close()
    })
  }
}
