package com.rock.stock.service

import com.rock.stock.eneity.BalanceSheet
import com.rock.stock.eneity.CashFlowStatement
import com.rock.stock.eneity.IncomeStatment

/**
 * @author rock
 */
abstract class FinanceDataService(symbol:String, reportType:String, `type`:String) {
    def getBalanceSheet:BalanceSheet
    def getCashFlowStatement:CashFlowStatement
    def getIncomeStatement:IncomeStatment
}