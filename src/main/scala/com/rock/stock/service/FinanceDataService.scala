package com.rock.stock.service

import com.rock.stock.model.ReportType
import com.rock.stock.model.FinanceType
import com.rock.stock.model.resource.StockFinanceResource

/**
 * @author rock
 */
abstract class FinanceDataService(resource:StockFinanceResource) {
 
  
  def getFinanceData:Seq[Seq[String]] = ???
}
 
