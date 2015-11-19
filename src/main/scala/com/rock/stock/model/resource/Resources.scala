package com.rock.stock.model.resource
import com.rock.stock.model._
import java.io.File
import com.sun.corba.se.impl.protocol.NotExistent
sealed abstract class Resource
case class FileResource(path: String) extends Resource
case class NotExistResource() extends Resource
case class StockFinanceResource(symbol: String, financeType: FinanceType, reportType: ReportType) extends Resource

object Resource extends App {
  private val reportRegex = s"^/(\\d+)/($main_financial_metric|$balance_sheet|$income_statment|$cash_flow_statment)/($year|$season|$report)\\b".r

  class FinanceString(str: String) {
    def toFinanceType = FinanceType(str)
    def toReportType = ReportType(str)
  }
  implicit def toFinanceString(str: String) = new FinanceString(str)

  def apply(path: String): Resource = {
    reportRegex.findFirstMatchIn(path) match {
      case Some(matcher) => StockFinanceResource(matcher.group(1), matcher.group(2).toFinanceType.get, matcher.group(2).toReportType.get)
      case None =>
        val realPath = getRealFilePath(path)
        if (isAFile(realPath)) FileResource(realPath) else NotExistResource()
    }
  }

  def getRealFilePath(path: String) = {
    classOf[Resource].getResource("/").getPath + "web" + path
  }
  private def isAFile(path: String) = {
    val file = new File(path)
    file.exists() && file.isFile()
  }
  println(Resource("/bootstrap/js/bootstrap.js"))
}