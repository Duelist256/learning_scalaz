package day_9

import scalaz._
import Scalaz._

object IdExample extends App {
  val result = 1 visit {
    case x@(2|3) => List(x * 2)
  }

  val result2 = 3 visit {
    case x@(2|3) => List(x * 2)
  }

  println(result)
  println(result2)
}
