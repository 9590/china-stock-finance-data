package com.rock.stock.util
import spray.json._
import com.rock.stock.json.JsonProtocol._
import com.rock.stock.implict.RichString._
import com.rock.stock.model.FinanceDataValue
import DefaultJsonProtocol._
import com.rock.stock.model.NameData
/**
 * @author rock
 */
object RenderUtil extends App {

  def toStockFinanceData(data: Seq[Seq[String]]) = {

    val dataRows = data.tail
    val formatedDataRows = dataRows.filter { row => !row.isEmpty }.map { dataRow =>
      val itemName = dataRow.head
      val dataCols = dataRow.tail
      if(dataCols.isEmpty){
        JsObject("name" -> JsString(itemName), "data" -> JsArray())
      }
      else{
        val lastDataCols = dataCols.tail :+ "--" 
        val resultDataCols = for (i <- 0 until dataCols.length) yield {
          val incPercent = dataCols(i).incPercentTo(lastDataCols(i))
          if(dataCols.contains("0") && lastDataCols(i).contains("0")){
              println("incPercent:"+incPercent.toPercent + ", "+incPercent)
          }
          JsObject("value" -> JsString(dataCols(i)), "num" -> JsNumber(incPercent.toNum.getOrElse(0.0)), "incPercent" -> JsString(incPercent.toPercent))
        }
        JsObject("name" -> JsString(itemName), "data" -> JsArray(resultDataCols.toVector))
      }
    }
    JsObject("head" -> JsArray(data.head.toVector.map(JsString(_))),
      "body" -> JsArray(formatedDataRows.toVector))

  }
}