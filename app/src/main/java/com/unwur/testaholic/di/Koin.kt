package com.unwur.testaholic.di

import com.unwur.testaholic.core.api.CurrencyApiImpl
import com.unwur.testaholic.core.api.ICurrencyApi
import com.unwur.testaholic.core.repo.CurrencyRepo
import com.unwur.testaholic.core.repo.ICurrencyRepo
import com.unwur.testaholic.core.usecase.GetLatestCurrencyUsecase
import com.unwur.testaholic.ui.viewmodel.CurrencyListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val appModule = module {
    single {
        httpClient
    }

    single<ICurrencyApi> {
        CurrencyApiImpl(client = get())
    }

    single<ICurrencyRepo> {
        CurrencyRepo(currencyApi = get())
    }

    single {
        GetLatestCurrencyUsecase(repo = get())
    }

    factory {
        CurrencyListViewModel(getLatestCurrencyUsecase = get())
    }
}


val httpClient = HttpClient() {
    install(Logging) {

    }
    install(ContentNegotiation) {
        json()
    }
}