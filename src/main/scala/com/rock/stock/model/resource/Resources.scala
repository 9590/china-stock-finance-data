package com.rock.stock.model.resource

import com.rock.stock.model._
import java.io.File
import com.sun.corba.se.impl.protocol.NotExistent
import com.rock.stock.model.http.ContentType
import com.rock.stock.model.http.JsonContentType
import com.rock.stock.model.http.TextHtmlContentType
import com.rock.stock.model.http.TextCssContentType
import com.rock.stock.model.http.TextHtmlContentType
import com.rock.stock.model.http.JavascriptContentType

sealed abstract class Resource

case class FileResource(path: String) extends Resource {
  def contentType = {
    path match {
      case path if path.endsWith(".json") => Some(JsonContentType("utf-8"))
      case path if path.endsWith(".js") => Some(JavascriptContentType())
      case path if path.endsWith(".css") => Some(TextCssContentType())
      case path if path.endsWith(".html") => Some(TextHtmlContentType("utf-8"))
      case path if path.endsWith(".htm") => Some(TextHtmlContentType("utf-8"))
      case _ => None
    }
  }
}

case object NotExistResource extends Resource

case class StockFinanceResource(symbol: String, financeType: FinanceType, reportType: ReportType) extends Resource

case class StockSearchResource(word: String) extends Resource

object Resource {

  class FinanceString(str: String) {
    def toFinanceType = FinanceType(str)

    def toReportType = ReportType(str)
  }

  implicit def toFinanceString(str: String) = new FinanceString(str)

  def apply(path: String, params: Map[String, List[String]]): Resource = {
    val reportRegex = s"^/(\\d+)/($main_financial_metric|$balance_sheet|$income_statment|$cash_flow_statment)/($year|$season|$report)\\b".r
    val search = "/stocks\\b".r
    reportRegex.findFirstMatchIn(path) match {
      case Some(matcher) => StockFinanceResource(matcher.group(1), matcher.group(2).toFinanceType.get, matcher.group(3).toReportType.get)
      case None =>
        path match {
          case "/stocks" => StockSearchResource(params("word").mkString(","))
          case _ =>
            val realPath = getRealFilePath(path)
            if (isAFile(realPath)) FileResource(realPath) else NotExistResource

        }
    }

  }

  def getRealFilePath(path: String) = {
    var rootPath = classOf[Resource].getResource("/").getPath
    rootPath = "E:/program_data/workspace/github_rep/china-stock-finance-data/src/main/resources/"
    path match {
      case path if path == "/" || path.startsWith("/?") => rootPath + "web/index.html"
      case _ => rootPath + "web" + path
    }

  }

  private def isAFile(path: String) = {
    val file = new File(path)
    file.exists() && file.isFile()
  }

}