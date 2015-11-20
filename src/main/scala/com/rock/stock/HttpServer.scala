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
import java.io.File
import com.rock.stock.model.resource.Resource
import com.rock.stock.model.resource.StockFinanceResource
import com.rock.stock.model.resource.FileResource
import com.rock.stock.model.resource.NotExistResource
import com.rock.stock.service.Net163FinanceDataService
import com.rock.stock.handler.WebHandler
/**
 * @author rock
 */
object HttpServer extends Logger with App {
  val port = 9999
  val actorSystem = ActorSystem("stock-finance")
  val routes = Routes({
    case GET(request) => {
      actorSystem.actorOf(Props[WebHandler]) ! request
    }
  })
  val webServer = new WebServer(WebServerConfig(port = port), routes, actorSystem)
  webServer.start()

  Runtime.getRuntime.addShutdownHook(new Thread {
    override def run { webServer.stop() }
  })

  System.out.println(s"Open your browser and navigate to http://localhost:$port")
}
