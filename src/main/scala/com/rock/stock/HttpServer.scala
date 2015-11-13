package com.rock.stock

import org.mashupbots.socko.routes._
import org.mashupbots.socko.infrastructure.Logger
import org.mashupbots.socko.webserver.WebServer
import org.mashupbots.socko.webserver.WebServerConfig

import akka.actor.ActorSystem
import akka.actor.Props
import org.mashupbots.socko.events.HttpRequestEvent
import akka.actor.Actor
import java.util.Date
/**
 * @author rock
 */
object HttpServer extends Logger with App {
  val port = 9999
  val actorSystem = ActorSystem("stock-finance")
  val routes = Routes({
    case GET(request) => {
      actorSystem.actorOf(Props[StockDataHandler]) ! request
    }
  })
  val webServer = new WebServer(WebServerConfig(port = port), routes, actorSystem)
  webServer.start()

  Runtime.getRuntime.addShutdownHook(new Thread {
    override def run { webServer.stop() }
  })

  System.out.println(s"Open your browser and navigate to http://localhost:$port")
}

/**
 * Hello processor writes a greeting and stops.
 */
class StockDataHandler extends Actor {
  def receive = {
    case event: HttpRequestEvent =>
      println("process request ...")
      event.response.write("hello world")
      handle(event)
      context.stop(self)
  }

  def handle(event: HttpRequestEvent) {
    val path = event.endPoint.path
    path match {
      case "/" => readFile(path)
      case _ => ""
    }
  }
  
  private def readFile(path:String){
    
  }
}