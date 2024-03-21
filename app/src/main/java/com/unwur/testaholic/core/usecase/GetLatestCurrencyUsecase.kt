package com.unwur.testaholic.core.usecase

import com.unwur.testaholic.core.api.model.CurrencyModel
import com.unwur.testaholic.core.repo.ICurrencyRepo

class GetLatestCurrencyUsecase(private val repo: ICurrencyRepo) {
    suspend fun getLatestCurrency(): List<CurrencyModel> {
        return repo.getLatestCurrency()
    }
}