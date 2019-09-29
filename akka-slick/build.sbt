scalaVersion := "2.12.10"

val akkaV = "2.5.11"
val slickVersion = "3.3.0"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.0"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % akkaV
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.10"
libraryDependencies += "com.typesafe.slick" %% "slick" % slickVersion
libraryDependencies += "com.typesafe.slick" % "slick-hikaricp_2.12" % slickVersion
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.11"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
