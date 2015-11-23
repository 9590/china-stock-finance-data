package test
import com.typesafe.config.ConfigFactory
/**
 * @author rock
 */
object MyTest extends App {
    println(1234590)
    val conf = ConfigFactory.load();
    println(conf.getObject("foo"))
}