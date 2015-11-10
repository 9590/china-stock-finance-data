package com.rock.stock.cfg
import scala.collection.mutable.ArrayBuffer
import scalaj.http.Http
import scalaj.http.HttpOptions
/**
 * @author rock
 */
object StocksRepository {
  val urlRepos = Array(
    "http://app.finance.ifeng.com/hq/list.php?type=stock_a&class=ha",
    "http://app.finance.ifeng.com/hq/list.php?type=stock_a&class=sa",
    "http://app.finance.ifeng.com/hq/list.php?type=stock_a&class=gem")

  lazy val stocks = {
    val stockRegex = "http://finance.ifeng.com/app/hq/stock/(sh|sz)([0-9]+)/index.shtml".r
    urlRepos.flatMap { url =>
      val res = Http(url).option(HttpOptions.connTimeout(111000)).option(HttpOptions.readTimeout(511000)).asString
      stockRegex.findAllIn(res.body).matchData.map {
        matchText => matchText.group(2)
      }
    }
  }

}
object TestStockRepository extends App {
  println(StocksRepository.stocks.mkString("\n"))
}