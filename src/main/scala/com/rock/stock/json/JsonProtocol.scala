package com.rock.stock.json
import spray.json._
import DefaultJsonProtocol._
import com.rock.stock.util.Huma
import com.rock.stock.model.StockSearchInfo
/**
 * @author rock
 */
object JsonProtocol extends DefaultJsonProtocol {
  implicit val stockSearchInfoFormat = jsonFormat5(StockSearchInfo)
  
}