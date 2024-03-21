package com.unwur.testaholic.core.repo

import com.unwur.testaholic.core.api.ICurrencyApi
import com.unwur.testaholic.core.api.model.CurrencyModel

interface ICurrencyRepo {
    suspend fun getLatestCurrency(): List<CurrencyModel>
}

class CurrencyRepo(private val currencyApi: ICurrencyApi): ICurrencyRepo {
    override suspend fun getLatestCurrency(): List<CurrencyModel> {
        return currencyApi.getBaseConversion()
    }
}