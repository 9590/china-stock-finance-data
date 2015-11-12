package com.rock.stock.service
import com.rock.stock.eneity.BalanceSheet
import com.rock.stock.eneity.CashFlowStatement
import com.rock.stock.eneity.IncomeStatment
import scalaj.http.Http
import scalaj.http.HttpOptions
import com.github.tototoshi.csv.CSVReader
import java.io.FileOutputStream
import java.util.Date
import java.text.SimpleDateFormat
import org.apache.poi.ss.usermodel._
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.ByteArrayInputStream
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle
import com.rock.stock.util.CSVUtil
import java.io.StringReader
import com.rock.stock.eneity.BalanceSheet

/**
 * @author rock
 */


/**
 * @author rock
 */
class Net163FinanceDataService(symbol:String, reportType:String, `type`:String) extends FinanceDataService(symbol, reportType, `type`)  {
    //val symbol = "002230"
  val exportFile = "D:/a/f.html"
 // val reportType = "zcfzb" // zycwzb(主要财务指标), zcfzb(资产负债表), lrb(利润表), xjllb(现金流量表)
//  val `type` = "year" // year, season or report

  
  
  override def getBalanceSheet: BalanceSheet = {
     val url = s"http://quotes.money.163.com/service/${reportType}_$symbol.html?type=${`type`}" //year season report
     val csv = Http(url).option(HttpOptions.connTimeout(111000)).option(HttpOptions.readTimeout(511000)).asBytes
     val data = CSVUtil.readCSV(new StringReader(new String(csv.body, "gb2312")))
     data.foreach { println  }
     return new BalanceSheet(data)
  }
  override def getCashFlowStatement: CashFlowStatement = null
  override def getIncomeStatement: IncomeStatment = null
}