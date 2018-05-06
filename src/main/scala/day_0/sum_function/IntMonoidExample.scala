package day_0.sum_function

object IntMonoidExample extends App {
  object IntMonoid {
    def mappend(a: Int, b: Int): Int = a + b
    def mzero: Int = 0
  }

  def sum(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)
  println(sum(List(1, 2, 3, 4)))
}
