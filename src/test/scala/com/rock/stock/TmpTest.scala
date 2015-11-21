package com.rock.stock
import spray.json._
import DefaultJsonProtocol._

/**
 * Created by rock on 2015/11/21.
 */
object TmpTest extends App{
  implicit val colorFormat = jsonFormat4(Color)
    println(List(Seq(1,2,30), Seq(4,5,6)).toJson)
  println(Color("good-2", 1, 2, 3).toJson)
}
case class Color(name: String, red: Int, green: Int, blue: Int)
