name := "china-stock-finance-data"

scalaVersion := "2.11.2"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

resolvers += "codahale" at "http://repo.codahale.com"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.11"

libraryDependencies += "com.sksamuel.scrimage" %% "scrimage-core" % "1.4.1"

libraryDependencies += "com.sksamuel.scrimage" %% "scrimage-canvas" % "1.4.1"

libraryDependencies += "com.sksamuel.scrimage" %% "scrimage-filters" % "1.4.1"

libraryDependencies += "commons-httpclient" % "commons-httpclient" % "3.1"

 
libraryDependencies += "org.jsoup" % "jsoup" % "1.6.3" 

libraryDependencies += "org.scalaj" %% "scalaj-http" % "1.1.3"

libraryDependencies += "org.apache.poi" % "poi" % "3.12"
 

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"

libraryDependencies += "io.searchbox" % "jest" % "0.1.3"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.7"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.5"

libraryDependencies += "org.littleshoot" % "littleproxy" % "1.0.0-beta7"

libraryDependencies +=  "com.alibaba" % "fastjson" % "1.1.41"
 
 
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.1"

libraryDependencies += "org.mashupbots.socko" % "socko-webserver_2.11" % "0.6.0"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.1.2"

libraryDependencies += "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.11"

libraryDependencies += "org.codehaus.jackson" % "jackson-core-asl" % "1.9.11"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"

libraryDependencies += "org.apache.directory.studio" % "org.dom4j.dom4j" % "1.6.1"

libraryDependencies += "com.scalatags" % "scalatags_2.11" % "0.4.2"

libraryDependencies += "log4j" % "log4j" % "1.2.17"

libraryDependencies += "com.google.code.gson" % "gson" % "2.2.2"

libraryDependencies += "com.github.kevinsawicki" % "http-request" % "6.0"
 
libraryDependencies += "commons-dbutils" % "commons-dbutils" % "1.5"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.19"

libraryDependencies += "com.scalatags" % "scalatags_2.11" % "0.4.3-M3"
 
libraryDependencies += "jaxen" % "jaxen" % "1.1.4"
 

libraryDependencies += "org.apache.poi" % "poi" % "3.10.1"

libraryDependencies += "org.apache.poi" % "poi-scratchpad" % "3.10.1"

libraryDependencies += "org.apache.poi" % "poi-ooxml" % "3.10.1"

libraryDependencies += "org.apache.poi" % "poi-ooxml-schemas" % "3.10.1"

 
 