import zio._
import zio.console.putStr
import scala.util.{Failure, Success, Try}

object CreateEffectFromPromise extends App {

  private def transformStringToUpperCase(str: String) = str.toUpperCase

  val app = for {
    promise <- ZIO.succeed(scala.concurrent.Promise[String]())
    _ <- ZIO.effect{
      Try{
        transformStringToUpperCase("hello world from future...!")
      } match {
        case Success(value) => promise.success(value)
        case Failure(exception) => promise.failure(exception)
      }
    }.fork
    value <- ZIO.fromPromiseScala(promise)
    _ <- putStr(value)
  } yield()

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = app.exitCode
}
