package com.rock.stock.model

object path extends App {
  private val reportRegex = "/(zycwzb|zcfzb|lrb|xjllb)/(year|season|report)".r

  class FinanceString(str: String) {
    def toFinanceType = FinanceType.fromString(str).get
  }
  implicit def toFinanceString(str: String) = new FinanceString(str)
   
  def unapply(path: String) = {
    reportRegex.findFirstMatchIn(path) match {
      case Some(mat) =>
        val financeType = mat.group(1)
        Some(FinaceDataReport(mat.group(1).toFinanceType, year))
      case None => None
    }

  }

   "/zcfzb/year" match {
     case path(financeData) => println(financeData)
     case _ => println("not match")
   }
  
  

}