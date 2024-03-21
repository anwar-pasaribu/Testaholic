package com.unwur.testaholic.ui

import androidx.compose.runtime.Composable
import com.unwur.testaholic.di.appModule
import com.unwur.testaholic.ui.screen.list.CurrencyListScreen
import com.unwur.testaholic.ui.theme.TestaholicTheme
import org.koin.compose.KoinApplication

@Composable
fun AppScreen() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        TestaholicTheme {
            CurrencyListScreen()
        }
    }
}