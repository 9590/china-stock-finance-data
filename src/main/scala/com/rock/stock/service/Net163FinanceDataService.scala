package com.rock.stock.service
import com.rock.stock.eneity.BalanceSheet
import com.rock.stock.eneity.CashFlowStatement
import com.rock.stock.eneity.IncomeStatment
import scalaj.http.Http
import scalaj.http.HttpOptions
import com.github.tototoshi.csv.CSVReader
import java.io.FileOutputStream
import java.util.Date
import java.text.SimpleDateFormat
import org.apache.poi.ss.usermodel._
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.ByteArrayInputStream
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle

/**
 * @author rock
 */
class Net163FinanceDataService extends FinanceDataService {
  override def getBalanceSheet: BalanceSheet = {
     val url = "" //s"http://quotes.money.163.com/cjmx/$year/$d/0$symbol.xls"
     val excel = Http(url).option(HttpOptions.connTimeout(111000)).option(HttpOptions.readTimeout(511000)).asBytes
    val book = new HSSFWorkbook(new ByteArrayInputStream(excel.body))
    val sheet = book.getSheetAt(0)
    val rows = sheet.getPhysicalNumberOfRows();
    val data = for (rowIndex <- 0 until rows) yield {
      val row = sheet.getRow(rowIndex)
      val colNum = row.getPhysicalNumberOfCells()
      for (colIndex <- 0 until colNum) yield {
        val cell = row.getCell(colIndex)
        cell.getCellType() match {
          case Cell.CELL_TYPE_NUMERIC => cell.getNumericCellValue() + ""
          case _ => cell.getStringCellValue()
        }
      }
    }
    null
  }
  override def getCashFlowStatement: CashFlowStatement = null
  override def getIncomeStatement: IncomeStatment = null
}