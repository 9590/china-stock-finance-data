package com.rock.stock.service

import com.rock.stock.model.StockSearchInfo

/**
 * @author rock
 */
trait StockSearchService {
    def search(word:String):Seq[StockSearchInfo]
}