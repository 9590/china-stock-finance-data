package com.rock.stock.service

import com.rock.stock.model.BalanceSheet
import com.rock.stock.model.CashFlowStatement
import com.rock.stock.model.IncomeStatment
import com.rock.stock.model.ReportType

/**
 * @author rock
 */
abstract class FinanceDataService(symbol: String, reportType: String, `type`: ReportType) {
  def getBalanceSheet: BalanceSheet
  def getCashFlowStatement: CashFlowStatement
  def getIncomeStatement: IncomeStatment
}
 
