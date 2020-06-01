import BookModels.{Author,Title,Id}

import scala.util.Random

object BookModels {
  type Title = String
  type Author = String
  type Id = String
  final case class BookId(value: String = Random.alphanumeric.take(8).foldLeft("")((result, c) => result + c))
}
case class Book(title: Title, author: Author)
case class BookWithId(id: Id, title: Title, author: Author)