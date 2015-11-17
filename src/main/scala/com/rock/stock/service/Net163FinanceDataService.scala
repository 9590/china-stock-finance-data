package com.rock.stock.service
import com.rock.stock.model._
import scalaj.http.Http
import scalaj.http.HttpOptions
import com.github.tototoshi.csv.CSVReader
import java.io.FileOutputStream
import java.util.Date
import java.text.SimpleDateFormat
import java.io.ByteArrayInputStream
import com.rock.stock.util.CSVUtil
import java.io.StringReader
import com.rock.stock.model.ReportType

/**
 * @author rock
 */

/**
 * @author rock
 */
class Net163FinanceDataService(symbol: String, financeType: FinanceType, `type`: ReportType) extends FinanceDataService(symbol, financeType, `type`) {
  //val symbol = "002230"
  val exportFile = "D:/a/f.html"
  // val reportType = "zcfzb" // zycwzb(主要财务指标), zcfzb(资产负债表), lrb(利润表), xjllb(现金流量表)
  //  val `type` = "year" // year, season or report

  override def getBalanceSheet: BalanceSheet = {
    val url = s"http://quotes.money.163.com/service/${financeType}_$symbol.html?type=${`type`}" //year season report
    val csv = Http(url).option(HttpOptions.connTimeout(111000)).option(HttpOptions.readTimeout(511000)).asBytes
    val data = CSVUtil.readCSV(new StringReader(new String(csv.body, "gb2312")))
    data.foreach { println }
    return new BalanceSheet(data)
  }
  override def getCashFlowStatement: CashFlowStatement = ???
  override def getIncomeStatement: IncomeStatment = ???
}