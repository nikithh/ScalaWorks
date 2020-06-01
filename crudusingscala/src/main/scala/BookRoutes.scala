
import BookModels.BookId
import cats.effect.IO
import io.circe.Json
import io.circe.generic.auto._
import org.http4s.circe.CirceEntityCodec._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
object BookRoutes {


  def routes(bookRepo: BookRepo): HttpRoutes[IO] = {

    val dsl = new Http4sDsl[IO]{}
    import dsl._

    HttpRoutes.of[IO] {
      case _ @ GET -> Root / "books" =>
        bookRepo.getBooks().flatMap(books => Ok(books))

      case req @ POST -> Root / "books" =>
        req.decode[Book] { book =>
          bookRepo.addBook(book) flatMap(id =>
            Created(Json.obj(("id", Json.fromString(id.value))))
            )
        }

      case _ @ GET -> Root / "books" / id =>
        bookRepo.getBook(BookId(id)) flatMap {
          case None => NotFound()
          case Some(book) => Ok(book)
        }

    }
  }

}