name := "ZIO-effect-from-scala-promise"

version := "0.1"
scalaVersion := "2.13.8"

val zioVersion = "1.0.14"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioVersion,
  // test dependency
  "dev.zio" %% "zio-test" % zioVersion % "test"
)
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

val root = (project in file("."))
