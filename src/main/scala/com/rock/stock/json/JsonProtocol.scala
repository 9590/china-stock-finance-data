package com.rock.stock.json
import spray.json._
import DefaultJsonProtocol._
import com.rock.stock.util.Huma
import com.rock.stock.model.StockSearchInfo
import com.rock.stock.model.FinanceDataValue
import com.rock.stock.model.NameData
/**
 * @author rock
 */
object JsonProtocol extends DefaultJsonProtocol {
  implicit val stockSearchInfoFormat = jsonFormat5(StockSearchInfo)
  implicit val financeDataValueFormat = jsonFormat3(FinanceDataValue)
  
}