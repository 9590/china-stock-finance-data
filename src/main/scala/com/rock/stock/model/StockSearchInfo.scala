package com.rock.stock.model

import com.rock.stock.util.JsonUtil

import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

/**
 * @author rock
 */
case class StockSearchInfo(`type`: String, symbol: String, tag: String, name: String, spell: String)  