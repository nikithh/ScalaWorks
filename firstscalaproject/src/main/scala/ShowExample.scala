import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import java.util.Date

object ShowExample extends App{
 implicit val dateShow: Show[Date] =
    Show.show(date => s"${date.getTime}ms since the epoch.")
  println(dateShow.show(new Date()))
  val showInt : Show[Int] = Show.apply[Int]
  val showString : Show[String] = Show.apply[String]
  val a = 123.show
  println("HelloWorld".show)
  println(a)
}
