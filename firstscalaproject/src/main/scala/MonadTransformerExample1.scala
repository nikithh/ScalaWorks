import cats.data.OptionT
import cats.data.OptionT._
import cats.syntax.applicative._
import cats.instances.list._
object MonadTransformerExample1 extends App{
  type ListOption[A] = OptionT[List, A]

  val a:ListOption[Int] = OptionT(List(Option(13),Option(45)))

  val b:ListOption[Int] = 32.pure[ListOption]

  println(a.flatMap { (x:Int) =>
    b.map { (y:Int) =>
      x + y
    }
  })
 }
