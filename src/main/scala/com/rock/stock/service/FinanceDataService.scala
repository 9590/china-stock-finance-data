package com.rock.stock.service

import com.rock.stock.eneity.BalanceSheet
import com.rock.stock.eneity.CashFlowStatement
import com.rock.stock.eneity.IncomeStatment

/**
 * @author rock
 */
trait FinanceDataService {
    def getBalanceSheet:BalanceSheet
    def getCashFlowStatement:CashFlowStatement
    def getIncomeStatement:IncomeStatment
}