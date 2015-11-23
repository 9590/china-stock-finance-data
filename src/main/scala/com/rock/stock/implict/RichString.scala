package com.rock.stock.implict

import java.text.NumberFormat
import java.math.RoundingMode

/**
 * @author rock
 */
class RichString(str: String) {
  lazy private val num: Option[Double] = {
    str match {
      case null => None
      case _ => try {
        Some(str.toDouble)
      } catch {
        case t: Exception => None
      }
    }
  }
  def toPercent: String = {
    toPercent(num)
  }

  private def toPercent(num: Option[Double]) = {
    num.map { n =>
      val format = NumberFormat.getPercentInstance();
      format.setMinimumFractionDigits(2);
      format.setRoundingMode(RoundingMode.HALF_EVEN)
      format.format(n);
    }.getOrElse("--")

  }

  
  
  def incPercentTo(str2:String) = {
    val otherNum = new RichString(str2).toNum
    val res = for(n <- num; otherN <- otherNum) yield {
      if(otherN == 0) new RichString(null) else new RichString((n - otherN)/otherN + "")
    }
    res.map { richString => richString.toPercent }.getOrElse("--")
  }

  def isNegativeNum = {
    num.getOrElse[Double](-1) < 0
  }
  def toNum = num
}
object RichString extends App {
  implicit def toRichString(str: String) = new RichString(str)
  
  
}