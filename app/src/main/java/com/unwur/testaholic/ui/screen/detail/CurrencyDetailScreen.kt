package com.unwur.testaholic.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unwur.testaholic.model.CurrencyItem

@Composable
fun CurrencyDetailScreen(currencyItem: CurrencyItem) {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = currencyItem.currencyLabel)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = currencyItem.amount,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

    }
}