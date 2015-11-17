package com.rock.stock.model

/**
 * @author rock
 */
sealed trait FinanceType
object FinanceType {
  def apply(str: String) = {
    str match {
      case "zycwzb" => Some(main_financial_metric)
      case "zcfzb" => Some(balance_sheet)
      case "lrb" => Some(income_statment)
      case "xjllb" => Some(cash_flow_statment)
      case _ => None
    }
  }
}
//zycwzb(��Ҫ����ָ��), zcfzb(�ʲ���ծ��), lrb(�����), xjllb(�ֽ�������)
case object main_financial_metric extends FinanceType {
  override def toString = "zycwzb"
}

case object balance_sheet extends FinanceType {
  override def toString = "zcfzb"
}
case object income_statment extends FinanceType {
  override def toString = "lrb"
}
case object cash_flow_statment extends FinanceType {
  override def toString = "xjllb"
  def unapply(str: String) = this
}

