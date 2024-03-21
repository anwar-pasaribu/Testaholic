package com.unwur.testaholic.core.api.model

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyModel(
    val currencyLabel: String,
    val amount: Double
)

@Serializable
data class LatestCurrencyPrice(
    val data: Map<String, Double> = mapOf()
)
