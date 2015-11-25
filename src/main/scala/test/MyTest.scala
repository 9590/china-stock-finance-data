package test
import com.typesafe.config.ConfigFactory
import spray.json._
import DefaultJsonProtocol._
import com.rock.stock.implict.RichString._
/**
 * @author rock
 */
object MyTest extends App {
//    println(1234590)
//    val conf = ConfigFactory.load();
//    println(conf.getObject("foo"))
  println("2196900 ".incPercentTo("2682800 "))
  println(("rock", 18).toJson)
}