package day_0.polymorphism

object SubtypePolymorphism extends App {

  trait Plus[A] {
    def plus(a2: A): A
  }

  def plus[A <: Plus[A]](a1: A, a2: A): A = a1.plus(a2)
}
