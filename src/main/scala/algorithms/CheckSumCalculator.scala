package algorithms

class CheckSumCalculator{

object SingleSumChecksum {
  def computeChecksum(data: List[Int], modulus: Int = 251): Int = {
    var checksum = 0
    for (b <- data) {
      checksum = (checksum + b.toInt) % modulus
    }
    checksum
  }

  def translate(text: String): List[Int] = {
    var asciiList: List[Int] = List()
    for (char <- text) {
      asciiList = asciiList :+ char.toInt
    }
    asciiList
  }

  def main(args: Array[String]): Unit = {
    val data = translate("Hola")
    val checksum = computeChecksum(data)
    println(s"$checksum")
  }
}

}



