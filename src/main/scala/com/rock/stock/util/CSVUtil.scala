package com.rock.stock.util
import com.github.tototoshi.csv.CSVReader
import java.io.Reader
import java.io.Reader

/**
 * @author rock
 */
object CSVUtil {
  def readCSV(reader: Reader) = {
    val csvReader = CSVReader.open(reader)
    val data = csvReader.all
    csvReader.close
    data
  }
}