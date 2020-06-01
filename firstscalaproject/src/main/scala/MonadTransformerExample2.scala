import cats.data.OptionT
import cats.instances.either._
import cats.syntax.applicative._
object MonadTransformerExample2 extends App{
  type ErrorOr[A]=Either[String,A]
  type ErrorOrOption[A]=OptionT[ErrorOr,A]

  val a =10.pure[ErrorOrOption]
  val b=32.pure[ErrorOrOption]

  val c=a.flatMap(x=>b.map(y=>x+y))
  println(c)
}
