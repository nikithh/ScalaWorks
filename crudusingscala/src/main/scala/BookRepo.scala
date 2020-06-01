import BookModels.BookId
import cats.effect.IO

trait BookRepo {

  def addBook(book: Book): IO[BookId]
  def getBook(id: BookId): IO[Option[BookWithId]]
  def getBooks(): IO[List[BookWithId]]

}