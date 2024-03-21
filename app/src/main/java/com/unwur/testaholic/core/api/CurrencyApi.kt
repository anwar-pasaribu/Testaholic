package com.unwur.testaholic.core.api

import com.unwur.testaholic.core.api.model.CurrencyModel
import com.unwur.testaholic.core.api.model.LatestCurrencyPrice
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/*
{
  "data": {
    "EUR": 0.0000586338,
    "SGD": 0.000085855,
    "USD": 0.000064136
  }
}
https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_ibftEUz23WXZVrgTrkDYIWGDgjnHElmlHIvqsITF&currencies=EUR%2CUSD%2CSGD%2CCAD%2CTHB%2CIDR
 */
interface ICurrencyApi {
    suspend fun getBaseConversion(): List<CurrencyModel>
}

class CurrencyApiImpl(private val client: HttpClient): ICurrencyApi {
    val url = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_ibftEUz23WXZVrgTrkDYIWGDgjnHElmlHIvqsITF&currencies=EUR%2CUSD%2CSGD%2CCAD%2CTHB%2CIDR"
    override suspend fun getBaseConversion(): List<CurrencyModel> {
        val dataList = client.get(url).body<LatestCurrencyPrice>()
        return dataList.data.map {
            CurrencyModel(it.key, it.value)
        }
    }
}