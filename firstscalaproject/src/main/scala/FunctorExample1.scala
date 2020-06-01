import cats.Functor
import cats.instances.list._
import cats.instances.option._
object FunctorExample1 extends App{


  val l = List(1,2,3,4,5)
  println(Functor[List].map(l)(_*2))

  //Using Option
  val a = List(Some(1),None,Some(5),Some(7))

  //Using normal map method
  println(a.map(_.map(_*2)))

  //Using functor
  println(Functor[List].compose[Option].map(a)(_*2))
}
