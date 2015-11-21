package com.rock.stock.model

import com.fasterxml.jackson.databind.node.{ ArrayNode, ObjectNode }
import com.rock.stock.util.JsonUtil

import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

/**
 * @author rock
 */
class StockSearchInfo() {
  @BeanProperty var `type`: String = null
  @BeanProperty var symbol: String = null
  @BeanProperty var tag: String = null
  @BeanProperty var name: String = null
  @BeanProperty var spell: String = null
}

object StockSearchInfo {
  def apply(`type`: String, symbol: String, tag: String, name: String, spell: String) = {
    val info = new StockSearchInfo
    info.`type` = `type`
    info.symbol = symbol
    info.tag = tag
    info.name = name
    info.spell = spell
    info
  }

  def apply(jsonObj: ObjectNode): StockSearchInfo = {
    val `type` = jsonObj.get("type").asText()
    val symbol = jsonObj.get("symbol").asText()
    val tag = jsonObj.get("tag").asText()
    val name = jsonObj.get("name").asText()
    val spell = jsonObj.get("spell").asText()
    StockSearchInfo(`type`, symbol, tag, name, spell)
  }

  def apply(jsonArrStr: String): Seq[StockSearchInfo] = {
    val arr = JsonUtil.fromJson(jsonArrStr, classOf[ArrayNode])
    val infos = ArrayBuffer.empty[StockSearchInfo]
    for (i <- 0 until arr.size()) {
      infos += StockSearchInfo(arr.get(i).asInstanceOf[ObjectNode])
    }
    infos
  }

}