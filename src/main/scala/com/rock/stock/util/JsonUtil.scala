package com.rock.stock.util

import org.json4s._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.{read, write}
import org.json4s.jackson.JsonMethods._
import com.rock.stock.model.StockSearchInfo
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.{ContainerNode, ArrayNode}

/**
 * @author rock
 */
object JsonUtil extends App {

  def toJson[Bean <: AnyRef](bean: Bean) = {
    implicit val formats = Serialization.formats(NoTypeHints)
    write(bean)
  }

  def fromJson[Bean <: ContainerNode[_]](json: String, clazz:Class[Bean]) = {
    val om = new ObjectMapper()
    om.readValue(json, clazz)
  }
   val om = new ObjectMapper()
   val js = om.writeValueAsString(Seq(StockSearchInfo("a", "b", "c", "d", "f")))
   println(toJson(Seq(StockSearchInfo("a", "b", "c", "d", "f"))))
}