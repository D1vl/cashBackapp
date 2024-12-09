package com.example.cashbackapp.ui.theme.OptionScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.cashbackapp.R
import com.example.cashbackapp.ui.theme.MyCardsScreenState
import com.example.cashbackapp.ui.theme.MyCardsViewModel

@Composable
fun CardsRowOption(
    viewModel: MyCardsViewModel
) {
    val screenState = viewModel.screenState.observeAsState(MyCardsScreenState())

    var dialogState by remember {
        mutableStateOf(false)
    }
    if (dialogState) {
        DialogWithGrids(
            onClick = { viewModel.selectGridType(it) },
            onDisMissRequest = { dialogState = false }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalAlignment = Alignment.Start
    ) {
        GripTypeOption(
            onOptionClick = {
                Log.d("TEST123", "Клик по настройке \"Выберите тип отображения\\")
                dialogState = true
            },
            gripTypeText = { stringResource(screenState.value.gridSettings.id) }
        )
        WidgetOption(
            onOptionClick = { Log.d("TEST123", "Клик по настройке \"Порядок карт\"") }
        )
        NotificationOption(
            onUpdateCashbackToggle = {},
            onNewOffersToggle = {},
            onRecommendationToggle = {},
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Log.d("TEST123", "Клик по настройке \"Сбросить все карты\"")
                }
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp,
                        vertical = 16.dp
                    )
                    .align(Alignment.CenterHorizontally),
                text = stringResource(R.string.option_delete_all_cards_title),
                fontSize = 17.sp,
                color = Color.Red
            )
        }
    }
}

@Composable
fun DialogWithGrids(
    onDisMissRequest: () -> Unit,
    onClick: (CardGridType) -> Unit,
) {
    Dialog(onDismissRequest = { onDisMissRequest() }) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = stringResource(R.string.dialog_choose_grid_type_title))
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    TextButton(
                        onClick = {
                            onClick(CardGridType.ONE_ROW)
                            onDisMissRequest()
                        }
                    ) {
                        Text(text = stringResource(R.string.option_one_row_value))
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Row {
                    TextButton(
                        onClick = {
                            onClick(CardGridType.TWO_ROW)
                            onDisMissRequest()
                        }
                    ) {
                        Text(text = stringResource(R.string.option_two_row_value))
                    }
                }
            }
        }
    }
}