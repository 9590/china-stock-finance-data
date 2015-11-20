package com.rock.stock

import com.rock.stock.service.Net163FinanceDataService
import com.rock.stock.model.year
import com.rock.stock.model.FinanceType
import com.fasterxml.jackson.databind.ObjectMapper
import scala.collection.JavaConversions.asJavaCollection
import com.rock.stock.model.resource.Resource
/**
 * @author rock
 */
object TestApp extends App {
  //    val s = new Net163FinanceDataService("601766","zcfzb",year)
  // //   s.getBalanceSheet
  //    s.getCashFlowStatement

  //    val a = 1
  //    if(a == 1){
  //      import java.util._
  //      val list = new ArrayList[String]()
  //      list.add("a")
  //      list.add("b")
  //      println(list.size())
  //    }

  //  System.out.println(FinanceType.fromString("zycwz+b"))
  //  val number: Double = 5.01
  //  number match {
  //    case Square(n) => println(s"square root of $number is $n")
  //    case _ => println("nothing matched")
  //  }
 
//   val om = new ObjectMapper
//   
//   val json = om.writeValueAsString(asJavaCollection(List("a","b", Map("id"->123, "name"->"rock"))))
//   println(json)
  println(Resource("/600000/zycwzb/year"))
}

object Square {
  def unapply(z: Double): Option[Double] = if (z > 10) Some(math.sqrt(z)) else None
}