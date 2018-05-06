package day_0.sum_function

object MethodInjectionExample extends App {
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

  trait MonoidOp[A] {
    val F: Monoid[A]
    val value: A
    def |+|(a2: A): A = F.mappend(value, a2)
  }

  implicit def toMonoidOp[A: Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
    val F: Monoid[A] = implicitly[Monoid[A]]
    val value: A = a
  }

  println(3 |+| 4)
  println("Hello" |+| ", World!")
}
