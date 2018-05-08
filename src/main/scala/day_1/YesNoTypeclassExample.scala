package day_1

object YesNoTypeclassExample extends App {

  trait CanTruthy[A]  { self =>
    def truthys(a: A): Boolean
  }

  object CanTruthy {
    def apply[A](implicit ev: CanTruthy[A]): CanTruthy[A] = ev
    def truthys[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
      override def truthys(a: A): Boolean = f(a)
    }
  }

  trait CanTruthyOps[A] {
    def self: A
    implicit def F: CanTruthy[A]
    final def truthy: Boolean = F.truthys(self)
  }

  object ToCanIsTruthyOps {
    implicit def toCanIsTruthyOps[A](v: A)(implicit ev: CanTruthy[A]): CanTruthyOps[A] =
      new CanTruthyOps[A] {
        def self: A = v
        implicit def F: CanTruthy[A] = ev
      }
  }


  import ToCanIsTruthyOps._

  implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truthys({
    case 0 => false
    case _ => true
  })

  println("= Int =")
  println(0.truthy)
  println(10.truthy)

  implicit def listCanTruthy[A]: CanTruthy[List[A]] = CanTruthy.truthys({
    case Nil => false
    case _ => true
  })

  println("= List =")
  println(List(1, 2, 3, 4).truthy)
  println(List().truthy)
  println(List("qwe", "asdasd", "xzzxz", "cv").truthy)
//  println(Nil.truthy) // compile error because of the nonvariance

  implicit val nilCanTruthy: CanTruthy[Nil.type] = CanTruthy.truthys(_ => false)
  println(Nil.truthy)

  implicit val booleanCanTruthy: CanTruthy[Boolean] = CanTruthy.truthys(identity)
  println("= Boolean =")
  println(false.truthy)
  println(true.truthy)

  def truthyIf[A: CanTruthy, B, C](cond: A)(ifyes: => B)(ifno: => C) =
    if (cond.truthy) ifyes
    else ifno

  println("\n= truthyIf test = ")
  println(truthyIf(Nil){"Yes"}{"No"})
  println(truthyIf(1){"Yes"}{"No"})
  println(truthyIf(2 :: 3 :: Nil){"Yes"}{"No"})
  println(truthyIf(false){"Yes"}{"No"})
}
