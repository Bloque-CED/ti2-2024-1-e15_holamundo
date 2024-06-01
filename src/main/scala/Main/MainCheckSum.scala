package Main

import algorithms.*
import data.*
import java.io.FileWriter
import java.io.BufferedWriter
import scala.collection.mutable.ArrayBuffer

/**
 * The MainCheckSum object is responsible for generating data, calculating checksums, and recording execution times.
 */
object MainCheckSum {

  /**
   * The main method that executes the checksum generation and recording process.
   *
   * @param args the command-line arguments (not used)
   */
  def main(args: Array[String]): Unit = {

    // Initialize variables
    val categories = Array("Toy", "Small", "Medium", "Large") 
    val timeList = ArrayBuffer[Double]() 
    val startTime = System.currentTimeMillis() 

    
    // Create instances of necessary classes
    val checksumCalculator = new CheckSumCalculator
    val dataGenerator = new DataGenerator
    val converter = new Conver
    val dataFolderPath = "dataLoad" 
    val dataLoader = new DataLoader(dataFolderPath)
    val executionTimer = new ExecutionTimer

    
    // Loop through each category and generate data
    categories.foreach(category => {
      
      // Generate data based on the category
      val data = dataGenerator.generateStringData(category)

      // Measure the time for the checksum calculation
      val (checksum, executionTime) = executionTimer.measureTime(checksumCalculator.calculateChecksum(new String(data)))

      // Calculate the time difference
      val time = (System.currentTimeMillis() - startTime).toDouble / 1000

      // Add the time and checksum to their respective lists
      timeList += time
      println(s"Category: $category, Checksum: $checksum, Execution Time: $time milliseconds")

      // Save data to text file
      val fileName = s"$category.txt"
      dataLoader.saveToTextFile(fileName, Array(new String(data)))
    })

    // Save the time data to a file
    val fileWriter = new FileWriter("checksum_times.txt")
    val bufferedWriter = new BufferedWriter(fileWriter)
    timeList.foreach(time => bufferedWriter.write(time.toString + "\n"))
    bufferedWriter.close()
  }
}
