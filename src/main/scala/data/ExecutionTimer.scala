package data

class ExecutionTimer {
  def measureTime[R](block: => R): (R, Long) = {
    val start = System.nanoTime()
    val result = block
    val end = System.nanoTime()
    (result, end - start)
  }

}
