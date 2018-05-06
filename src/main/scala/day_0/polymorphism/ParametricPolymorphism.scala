package day_0.polymorphism

object ParametricPolymorphism extends App {
  def head[A](xs: List[A]): A = xs(0)
  println(head(1 :: 2 :: Nil))

  case class Car(make: String)
  println(head(Car("Civic") :: Car("CR-V") :: Nil))
}
