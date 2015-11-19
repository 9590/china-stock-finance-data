package com.rock.stock.model

import com.rock.stock.model.resource.StockFinanceResource
case class  RequestPath(path:String)
object RequestPath extends App{
  private val reportRegex = s"^/(\\d+)/($main_financial_metric|$balance_sheet|$income_statment|$cash_flow_statment)/($year|$season|$report)\\b".r
  
  class FinanceString(str: String) {
    def toFinanceType = FinanceType(str)
    def toReportType = ReportType(str)
  }
  implicit def toFinanceString(str: String) = new FinanceString(str)

  def unapply(path: String) = {
    reportRegex.findFirstMatchIn(path) match {
      case Some(mat) => Some(StockFinanceResource(mat.group(1), mat.group(2).toFinanceType.get, mat.group(3).toReportType.get))
      case None => None
    }

  }

  
}