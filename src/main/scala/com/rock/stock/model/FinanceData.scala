package com.rock.stock.model
import com.rock.stock.implict.RichString._
/**
 * @author rock
 */
case class FinanceData(title: FinanceDataTitle, data:Seq[FinanceDataItem]){
  def toSome = {
    val d = data.map { dataItem => 
       val firstData = dataItem.data
       val secondData:Seq[String] = dataItem.data.tail :+ "--"
       for(i <- 0 until dataItem.data.length) yield {
           val incPercent = firstData(i).incPercentTo(secondData(i))
           FinanceItemInfo(firstData(i), !incPercent.isNegativeNum, incPercent)
       } 
    }
  }
}
abstract class DataItem(title:String, data:Seq[String])
case class FinanceDataTitle(title:String, data:Seq[String]) extends DataItem(title, data)
case class FinanceDataItem(title:String, data:Seq[String]) extends DataItem(title, data)
case class FinanceItemInfo(data:String, `inc?`:Boolean, incPercent:String)

object FinanceData{
  def apply(data:Seq[Seq[String]]) = {
      new FinanceData(new FinanceDataTitle(data.head.head, data.head.tail), data.tail.map { row => new FinanceDataItem(row.head, row.tail) })
  }
}
 