package data

/**
 * The ExecutionTimer class provides a method to measure the execution time of a given block of code.
 */
class ExecutionTimer {

  /**
   * Measures the execution time of a given block of code.
   *
   * @param block the block of code to be executed and measured
   * @tparam T the type of the result produced by the block of code
   * @return a tuple containing the result produced by the block of code and the execution time in milliseconds
   */
  def measureTime[T](block: => T): (T, Long) = {
    val startTime = System.nanoTime()
    val result = block
    val endTime = System.nanoTime()
    val elapsedTime = (endTime - startTime) / 1000000 // tiempo de ejecución en milisegundos
    (result, elapsedTime)
  }
}


