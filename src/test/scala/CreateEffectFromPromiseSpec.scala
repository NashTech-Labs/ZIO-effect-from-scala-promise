import zio.test._
import zio.test.Assertion._
import zio.test.environment._

object CreateEffectFromPromiseSpec extends DefaultRunnableSpec {
  def spec = suite("CreateEffectFromPromise")(
    testM("should display the output in upper case") {
      for {
        _      <- CreateEffectFromPromise.app
        output <- TestConsole.output
      } yield assert(output)(equalTo(Vector("HELLO WORLD FROM FUTURE...!")))
    }
  )
}