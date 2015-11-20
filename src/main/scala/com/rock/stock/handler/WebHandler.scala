package com.rock.stock.handler

import com.rock.stock.model.resource.NotExistResource
import com.rock.stock.service.Net163FinanceDataService
import com.rock.stock.model.resource.StockFinanceResource
import org.mashupbots.socko.events.HttpRequestEvent
import com.rock.stock.model.resource.FileResource
import com.rock.stock.model.resource.Resource
import java.io.File
import akka.actor.Actor
import scala.collection.JavaConversions.asJavaCollection
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.io.IOUtils
import java.io.FileInputStream
import org.mashupbots.socko.events.HttpResponseStatus
class WebHandler extends Actor {
 //http://quotes.money.163.com/stocksearch/json.do?type=&count=10&word=zgpa&t=0.4874892747054357
  //_ntes_stocksearch_callback([{"type":"SH","symbol":"601318","tag":"HS MYHS","spell":"ZGPA","name":"\u4e2d
//\u56fd\u5e73\u5b89"},{"type":"HK","symbol":"02318","tag":"HK","spell":"ZGPA","name":"\u4e2d\u56fd\u5e73
//\u5b89"}])
  def receive = {
    case event: HttpRequestEvent =>
      handle(event)
      context.stop(self)
  }

  def handle(event: HttpRequestEvent)  = {
    val path = event.endPoint.path
    println("request path:" + path);
    val res = Resource(path) match {
      case StockFinanceResource(symbol, financeType, reportType) =>
        val stockData = new Net163FinanceDataService(StockFinanceResource(symbol, financeType, reportType)).getFinanceData
        val jsonObj = asJavaCollection(stockData.map { stockDataRow => asJavaCollection(stockDataRow) })
        val om = new ObjectMapper
        (200, om.writeValueAsString(jsonObj), Some("application/json;charset=gb2312"))
      case FileResource(fileName) => (200, readFile(fileName), Some("text/html; charset=gb2312"))
      case NotExistResource => (404, "404 not found", None)
    }
    res._3.foreach { contentType => event.response.headers.append("Content-Type", contentType) }
    event.response.status = new HttpResponseStatus(res._1)
    event.response.write(res._2)
  }

  private def readFile(path: String) = {
    val input = new FileInputStream(path)
    val data = IOUtils.toString(input)
    input.close()
    data
  }

}