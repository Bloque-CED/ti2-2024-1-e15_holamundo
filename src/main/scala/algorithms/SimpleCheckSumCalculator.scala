package algorithms

class SimpleCheckSumCalculator extends CheckSumCalculator{
  override def calculateChecksum(data: String): Int = {
    data.map(_.toInt).sum
  }

}
