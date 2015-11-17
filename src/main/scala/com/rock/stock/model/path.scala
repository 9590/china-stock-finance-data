package com.rock.stock.model

object path{
  private val reportRegex = s"^/\\b($main_financial_metric|$balance_sheet|$income_statment|$cash_flow_statment)/($year|$season|$report)\\b".r

  class FinanceString(str: String) {
    def toFinanceType = FinanceType(str)
    def toReportType = ReportType(str)
  }
  implicit def toFinanceString(str: String) = new FinanceString(str)

  def unapply(path: String) = {
    reportRegex.findFirstMatchIn(path) match {
      case Some(mat) => Some(FinaceDataReport(mat.group(1).toFinanceType.get, mat.group(2).toReportType.get))
      case None => None
    }

  }


}