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
import com.rock.stock.model.resource.StockFinanceResource
import scala.collection.mutable.ArrayBuffer

/**
 * @author rock
 */

/**
 * @author rock
 */
class Net163FinanceDataService(resource: StockFinanceResource) extends FinanceDataService(resource) {
 
  val exportFile = "D:/a/f.html"
   
  override def getFinanceData = {
    val url = s"http://quotes.money.163.com/service/${resource.financeType}_${resource.symbol}.html?type=${resource.reportType}" //year season report
    val csv = Http(url).option(HttpOptions.connTimeout(111000)).option(HttpOptions.readTimeout(511000)).asBytes
    CSVUtil.readCSV(new StringReader(new String(csv.body, "gb2312")))
  }

}