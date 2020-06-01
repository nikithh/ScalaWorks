import cats.Monoid
import cats.instances.string._
import cats.instances.int._

import cats.syntax.semigroup._

object MonoidExample extends App {
  def add[A: Monoid](items: List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)
  println(Monoid[String].combine("Hello","World"))
  println(Monoid[Int].combine(5,6))
  println(5|+|6|+|7|+|8)
  println("Welcome"|+|"to"|+|"Publicis"|+|"Sapient"|+|Monoid[String].empty)
  println(add(List(1,2,3,4,5)))
}
