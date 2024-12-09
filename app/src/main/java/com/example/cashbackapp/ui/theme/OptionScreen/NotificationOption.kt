package com.example.cashbackapp.ui.theme.OptionScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cashbackapp.R

@Composable
fun NotificationOption(
    onUpdateCashbackToggle: (Boolean) -> Unit,
    onNewOffersToggle: (Boolean) -> Unit,
    onRecommendationToggle: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.option_notification_title),
            fontSize = 13.sp
        )
        NotificationToggle(
            onToggle = onUpdateCashbackToggle,
            titleText = { stringResource(R.string.option_cashback_updates_title) }
        )
        NotificationToggle(
            onToggle = onNewOffersToggle,
            titleText = { stringResource(R.string.option_new_offers_title) }
        )
        NotificationToggle(
            onToggle = onRecommendationToggle,
            titleText = { stringResource(R.string.option_recommendations_title) }
        )
    }
}

@Composable
private fun NotificationToggle(
    onToggle: (Boolean) -> Unit,
    titleText: @Composable () -> String,
) {
    var checked by remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clickable {
                checked = !checked
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier,
                text = titleText()
            )

            Switch(
                checked = checked,
                onCheckedChange = {
                    onToggle(it)
                    checked = it
                }
            )
        }
    }
}