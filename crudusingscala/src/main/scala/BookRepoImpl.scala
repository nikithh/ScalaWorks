import BookModels.BookId
import cats.effect.IO
import scala.collection.mutable.HashMap
object BookRepoImpl {
  class DummyImpl extends BookRepo {

    val storage = HashMap[BookId, Book]().empty

    override def addBook(book: Book): IO[BookId] = IO {
      val bookId = BookId()
      storage.put(bookId, book)
      bookId
    }

    override def getBook(id: BookId): IO[Option[BookWithId]] = IO {
      storage.get(id).map(book => BookWithId(id.value, book.title, book.author))
    }

    override def getBooks(): IO[List[BookWithId]] = IO {
      storage.map {case (id, book) => BookWithId(id.value, book.title, book.author)}.toList
    }
  }
}
