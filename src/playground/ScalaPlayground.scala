package playground

import scala.annotation.tailrec

object ScalaPlayground extends App {
  def stringify[A, B, C](t: (A, B, C)): (A, String, B, String, C, String) = {
    (t._1, t._1.toString, t._2, t._2.toString, t._3, t._3.toString)
  }

  println(stringify(1, 1.1, 1L))
}
