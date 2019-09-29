scalaVersion := "2.11.8"

libraryDependencies ++= {
  val akkaV = "2.4.10"
  Seq(
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV
  )
}