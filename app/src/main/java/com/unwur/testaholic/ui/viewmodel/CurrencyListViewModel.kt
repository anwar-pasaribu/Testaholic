package com.unwur.testaholic.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unwur.testaholic.core.usecase.GetLatestCurrencyUsecase
import com.unwur.testaholic.model.CurrencyItem
import kotlinx.coroutines.launch

class CurrencyListViewModel(
    private val getLatestCurrencyUsecase: GetLatestCurrencyUsecase
): ViewModel() {

    var currencyList = mutableStateOf<List<CurrencyItem>>(listOf())

    fun loadLatestCurrency() {
        viewModelScope.launch {
            val latestCurrency = getLatestCurrencyUsecase.getLatestCurrency()
            currencyList.value = latestCurrency.map {
                CurrencyItem(it.currencyLabel,
                    it.amount.toString())
            }
        }
    }
}