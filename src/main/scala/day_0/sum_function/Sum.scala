package day_0.sum_function

object Sum extends App {
  def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)

  println(sum(List(1, 2, 3, 4)))
}
