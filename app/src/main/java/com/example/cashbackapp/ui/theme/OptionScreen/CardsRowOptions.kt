package com.example.cashbackapp.ui.theme.OptionScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.cashbackapp.ui.theme.MyCardsViewModel

@Preview
@Composable
fun CardsRowOption(

) {

    var dialogState by remember {
        mutableStateOf(false)
    }
    if (dialogState) {
        DialogWithGrids(onDisMissRequest = { dialogState = false })
    }

    Column(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp)
            .fillMaxSize()
    ) {
        Card(modifier = Modifier
            .clickable {
                dialogState = true
            }
            .padding(bottom = 24.dp)) {


            Row {
                Text(text = "Cards display")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "One row")
            }
        }
        Text(
            modifier = Modifier.padding(),
            fontSize = 13.sp,
            text = "Widget"
        )
        Card {
            Text(
                text = "Card order",
                fontSize = 17.sp
            )

        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Notification",
            fontSize = 13.sp
        )
        Card {
            Column {
                Text(
                    text = "Cashback updates",
                    fontSize = 17.sp
                )
                Text(
                    text = "New offers",
                    fontSize = 17.sp
                )
                Text(
                    text = "Recommendations",
                    fontSize = 17.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Card {
            Text(
                text = "Delete all cards",
                fontSize = 17.sp
            )
        }
    }
}

@Composable
fun DialogWithGrids(
    onDisMissRequest: () -> Unit,
    viewModel: MyCardsViewModel,
    ) {



    Dialog(onDismissRequest = { onDisMissRequest() }) {
        Card {
            Column {
                Text(text = "Choose grid type")
                Row {
                    TextButton(onClick = { CardGridType.ONE_ROW }) {
                        Text(text = "One row")
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Row {
                    TextButton(onClick = { CardGridType.TWO_ROW }) {
                        Text(text = "Two row")
                    }
                }
            }
        }
    }
}