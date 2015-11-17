package com.rock.stock.service

import com.rock.stock.model.BalanceSheet
import com.rock.stock.model.CashFlowStatement
import com.rock.stock.model.IncomeStatment
import com.rock.stock.model.ReportType
import com.rock.stock.model.FinanceType

/**
 * @author rock
 */
abstract class FinanceDataService(symbol: String, financeType: FinanceType, `type`: ReportType) {
  def getBalanceSheet: BalanceSheet
  def getCashFlowStatement: CashFlowStatement
  def getIncomeStatement: IncomeStatment
}
 
