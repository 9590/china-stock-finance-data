package com.rock.stock.model

sealed trait ReportType
object ReportType {
  def apply(str: String) = {
    str match {
      case "year" => Some(year)
      case "season" => Some(season)
      case "report" => Some(report)
      case _ => None
    }
  }
}
case object year extends ReportType{
  override def toString() = "year"
}
case object season extends ReportType{
  override def toString() = "season"
}
case object report extends ReportType{
  override def toString() = "report"
}