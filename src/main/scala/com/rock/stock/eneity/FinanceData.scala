package com.rock.stock.eneity

/**
 * @author rock
 */
class FinanceData(data:Array[String])

case class BalanceSheet(data:Array[String]) extends FinanceData(data)

case class CashFlowStatement(data:Array[String]) extends FinanceData(data)

case class IncomeStatment(data:Array[String]) extends FinanceData(data)