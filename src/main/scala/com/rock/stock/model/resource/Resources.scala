package com.rock.stock.model.resource
import com.rock.stock.model._

import java.io.File
sealed abstract class Resource
case class FileResource(path: String) extends Resource
case class NotExistResource() extends Resource
case class StockFinanceResource(symbol: String, financeType: FinanceType, reportType: ReportType) extends Resource

object Resource {
  def apply(path: String) = {
    path match {
      case "/600153/zcfzb/year" => StockFinanceResource("", main_financial_metric, year)
      case "/index.html" => FileResource(path)
      case _ => NotExistResource
    }
  }
}