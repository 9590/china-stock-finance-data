name := "china-stock-finance-data"

scalaVersion := "2.11.2"

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

resolvers += "codahale" at "http://repo.codahale.com"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.11"

libraryDependencies += "org.scalaj" %% "scalaj-http" % "1.1.3"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"

libraryDependencies += "org.mashupbots.socko" % "socko-webserver_2.11" % "0.6.0"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.1.2"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"


libraryDependencies += "commons-io" % "commons-io" % "2.4"

libraryDependencies += "io.spray" % "spray-json_2.11" % "1.3.2"

libraryDependencies += "com.typesafe" % "config" % "1.3.0"


