package Main

import algorithms.CheckSumCalculator
import data.{Conver, DataGenerator, DataLoader, ExecutionTimer}
import java.io.FileWriter
import java.io.BufferedWriter
import scala.collection.mutable.ArrayBuffer

object MainCheckSum {
  def main(args: Array[String]): Unit = {
    // Initialize variables
    val categories = Array("Toy", "Small", "Medium", "Large") // Array of categories for data generation
    val timeList = ArrayBuffer[Double]() // Array to store execution times
    val startTime = System.currentTimeMillis() // Record the starting time

    // Create instances of necessary classes
    val checksumCalculator = new CheckSumCalculator
    val dataGenerator = new DataGenerator
    val converter = new Conver
    val dataLoader = new DataLoader
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
      println(s"Category: $category, Checksum: $checksum, Execution Time: $time seconds")
    })

    // Save the time data to a file
    val fileWriter = new FileWriter("checksum_times.txt")
    val bufferedWriter = new BufferedWriter(fileWriter)
    timeList.foreach(time => bufferedWriter.write(time.toString + "\n"))
    bufferedWriter.close()
  }
}