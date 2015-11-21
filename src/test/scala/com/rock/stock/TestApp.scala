package com.rock.stock

import com.rock.stock.service.Net163FinanceDataService
import com.rock.stock.model.year
import com.rock.stock.model.FinanceType
import scala.collection.JavaConversions.asJavaCollection
import com.rock.stock.model.resource.Resource
import com.rock.stock.model.StockSearchInfo
import com.rock.stock.util.JsonUtil
  

/**
 * @author rock
 */
object TestApp extends App {

  for(a <- Some[Int](1); c =a; b <- Some[String]("a")) {


  }

}

object Square {
  def unapply(z: Double): Option[Double] = if (z > 10) Some(math.sqrt(z)) else None
}