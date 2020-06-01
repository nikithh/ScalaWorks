import BookRepoImpl.DummyImpl
import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.server.Router
import org.http4s.implicits._
import org.http4s.server.blaze._
import cats.implicits._


object Main extends IOApp {

  private val bookRepo: BookRepo = new DummyImpl

  val httpRoutes = Router[IO](
    "/" -> BookRoutes.routes(bookRepo)
  ).orNotFound

  override def run(args: List[String]): IO[ExitCode] = {

    BlazeServerBuilder[IO]
      .bindHttp(9000, "0.0.0.0")
      .withHttpApp(httpRoutes)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
  }

}