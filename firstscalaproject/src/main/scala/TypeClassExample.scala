import BehavesLikeHumanInstances.dogBehavesLikeHuman
sealed trait Animal
final case class Dog(name: String) extends Animal

trait BehavesLikeHuman[A] {
  def speak(a: A): Unit
}

object BehavesLikeHumanInstances {
  implicit val dogBehavesLikeHuman = new BehavesLikeHuman[Dog] {
    def speak(dog: Dog): Unit = {
      println(s"I'm a Dog, my name is ${dog.name}")
    }
  }

}
object BehavesLikeHuman {
  def speak[A](a: A)(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
    behavesLikeHumanInstance.speak(a)
  }
}
object TypeClassExample extends App{


  val rover = Dog("Rover")
  BehavesLikeHuman.speak(rover)
}
