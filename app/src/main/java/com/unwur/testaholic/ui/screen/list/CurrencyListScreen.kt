package com.unwur.testaholic.ui.screen.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unwur.testaholic.model.CurrencyItem
import com.unwur.testaholic.ui.theme.TestaholicTheme
import com.unwur.testaholic.ui.viewmodel.CurrencyListViewModel
import org.koin.compose.koinInject


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyListScreen() {

    val viewModel = koinInject<CurrencyListViewModel>()
    viewModel.loadLatestCurrency()

    val currencyList  = viewModel.currencyList

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Testaholic") })
        }
    ) { paddingValues ->
        val currencies = (0..3).toList()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(currencyList.value) {
                val currencyItem = CurrencyItem(
                    it.currencyLabel, it.amount
                )
                CurrencyDisplayItem(
                    currencyItem
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyDisplayItem(currencyItem: CurrencyItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        border = CardDefaults.outlinedCardBorder(),
        onClick = { /*TODO*/ }) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = currencyItem.currencyLabel)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = currencyItem.amount,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
private fun CurrencyListScreenPreview() {
    TestaholicTheme {
        CurrencyListScreen()
    }
}