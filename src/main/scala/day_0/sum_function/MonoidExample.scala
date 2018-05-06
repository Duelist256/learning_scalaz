package day_0.sum_function

object MonoidExample extends App {

  trait Monoid[A] {
    def mappend(a1: A, a2: A): A
    def mzero: A
  }

  object Monoid {
    implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
      def mappend(a1: Int, a2: Int): Int = a1 + a2
      def mzero: Int = 0
    }
    implicit val StringMonoid: Monoid[String] = new Monoid[String] {
      def mappend(a1: String, a2: String): String = a1 + a2
      def mzero: String = ""
    }
  }


  def sum[A](xs: List[A], m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)
  import Monoid.IntMonoid
  println(s"sum: ${sum(List(1, 2, 3, 4), IntMonoid)}")

  def sumWithImplicit[A](xs: List[A])(implicit m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)

  println(s"sumWithImplicit: ${sumWithImplicit(List(1, 2, 3, 4))}")

  // as a context bound
  def sumWithImplicit2[A: Monoid](xs: List[A]): A = {
    val m = implicitly[Monoid[A]]
    xs.foldLeft(m.mzero)(m.mappend)
  }
  println(s"sumWithImplicit2: ${sumWithImplicit2(List(1, 2, 3, 4))}")

  val MuiltiMonoid: Monoid[Int] = new Monoid[Int] {
    def mappend(a1: Int, a2: Int): Int = a1 * a2
    def mzero: Int = 1
  }
  println(s"multiplication: ${sumWithImplicit(List(1, 2, 3, 4))(MuiltiMonoid)}")
}
