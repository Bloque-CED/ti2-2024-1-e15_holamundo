package data

import scala.util.Random

class DataGenerator {

  def generateData(size: Int): Array[Byte] = {
    val data = new Array[Byte](size)
    Random.nextBytes(data)
    data
  }

  def generateString(minSize: Int, maxSize: Int): String = {
    val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    val size = Random.nextInt(maxSize - minSize + 1) + minSize
    (1 to size).map(_ => source(Random.nextInt(source.length))).mkString
  }

  def chooseSizeRange(category: String): (Int, Int) = {
    category match {
      case "Toy" => (1, 101)
      case "Small" => (102, 9999)
      case "Medium" => (10000, 99999)
      case "Large" => (100000, 999999)
      case _ => throw new IllegalArgumentException("Invalid category size")
    }
  }

  def generateStringData(category: String): Array[Byte] = {
    val (minSize, maxSize) = chooseSizeRange(category)
    val randomString = generateString(minSize, maxSize)
    randomString.getBytes("UTF-8")
  }
}

//def generateStringData(category: String): Array[Byte] = {
//  val (minSize, maxSize) = chooseSizeRange(category)
// val randomString = generateString(minSize, maxSize)
//  randomString.getBytes // sin especificar la codificación
//}

//def generateData(size: Int): Array[Byte] = {
//  val data = new Array[Byte](size)
//  (0 until size).foreach(i => data(i) = (Math.random() * 256).toByte)
//  data
//}