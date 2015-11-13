package com.rock.stock.model

/**
 * @author rock
 */
class FinanceData(data:Seq[Seq[String]])

case class BalanceSheet(data:Seq[Seq[String]]) extends FinanceData(data)

case class CashFlowStatement(data:Seq[Seq[String]]) extends FinanceData(data)

case class IncomeStatment(data:Seq[Seq[String]]) extends FinanceData(data)

case class ZycwzbStatment(data:Seq[Seq[String]]) extends FinanceData(data)
