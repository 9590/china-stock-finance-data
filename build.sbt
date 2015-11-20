name := "china-stock-finance-data"

scalaVersion := "2.11.2"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

resolvers += "codahale" at "http://repo.codahale.com"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.11"

libraryDependencies += "org.scalaj" %% "scalaj-http" % "1.1.3"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"

libraryDependencies += "org.mashupbots.socko" % "socko-webserver_2.11" % "0.6.0"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.1.2"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"

libraryDependencies += "com.fasterxml.jackson.core" %  "jackson-core" % "2.5.2"

libraryDependencies += "com.fasterxml.jackson.core" %  "jackson-databind" % "2.5.2"

libraryDependencies += "commons-io" % "commons-io" % "2.4"
