import cats.{Applicative, Functor}
import cats.instances.all._

object FunctorExample2 extends App{
  //Generalizing map function for all types
  def map[F[_],A,B](fa: F[A])(f: A => B)(implicit F: Functor[F]): F[B] = {
    F.map(fa)(f)
  }
  println(map(Option(1))(_ * 2))
  println(map(List(1, 2, 3))(_ * 3))
  //Lifting a function

  def len(input:String):Int=input.length
  val newFunc=Functor[Option].lift(len)
  val s=Some("HelloWorld")
  println(newFunc(s))

  //using applicative to achieve the same
  println(Applicative[Option].ap(Some(len _))(s))

  //applicative to work with multiple parameter functions
  val add: (Int,Int) => Int = _ + _
  val b=Some(10)
  val c=Some(45)
  println(Applicative[Option].map2(b,c)(add))

}
