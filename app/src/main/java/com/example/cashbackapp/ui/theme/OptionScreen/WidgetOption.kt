package com.example.cashbackapp.ui.theme.OptionScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cashbackapp.R

@Composable
fun WidgetOption(
    onOptionClick: () -> Unit
) {
    Column {
        Text(
            modifier = Modifier.padding(),
            fontSize = 13.sp,
            text = stringResource(R.string.option_widget_title)
        )
        Card(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clickable {
                    onOptionClick()
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
                    text = stringResource(R.string.option_card_order_value)
                )
            }
        }
    }
}