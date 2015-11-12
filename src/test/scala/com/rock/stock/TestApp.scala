package com.rock.stock

import com.rock.stock.service.Net163FinanceDataService

/**
 * @author rock
 */
object TestApp extends App {
    val s = new Net163FinanceDataService("601766","zcfzb","year")
    s.getBalanceSheet
}