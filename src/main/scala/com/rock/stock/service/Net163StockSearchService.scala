package com.rock.stock.service

import com.rock.stock.model.StockSearchInfo
import scalaj.http.Http
import scalaj.http.HttpOptions
import spray.json._
import com.rock.stock.json.JsonProtocol._
import com.rock.stock.model.StockSearchInfo
/**
 * @author rock
 */
class Net163StockSearchService extends StockSearchService{
    override def search(word:String) = {
       val url = s"http://quotes.money.163.com/stocksearch/json.do?type=&count=10&word=$word&t=0.4874892747054357"
       val res = Http(url).option(HttpOptions.connTimeout(111000)).option(HttpOptions.readTimeout(511000)).asString.body
       val json = res.replaceFirst("_ntes_stocksearch_callback\\(", "").trim.dropRight(1)
       val stocks = json.parseJson.convertTo[Seq[StockSearchInfo]]
       stocks.filter { stock => stock.`type` == "SH" || stock.`type` == "SZ"}
    }
}