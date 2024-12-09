package com.example.cashbackapp.ui.theme.OptionScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import com.example.cashbackapp.R

@Composable
fun GripTypeOption(
    onOptionClick: () -> Unit,
     gripTypeText: @Composable () -> String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOptionClick() }
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
                text = stringResource(R.string.dialog_choose_grid_type_title)
            )
            Text(
                modifier = Modifier,
                text = gripTypeText()
            )
        }
    }
}