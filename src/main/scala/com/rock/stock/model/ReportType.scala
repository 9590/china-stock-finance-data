package com.rock.stock.model

sealed trait ReportType

case object year extends ReportType{
  override def toString() = "year"
}
case object season extends ReportType{
  override def toString() = "season"
}
case object report extends ReportType{
  override def toString() = "report"
}