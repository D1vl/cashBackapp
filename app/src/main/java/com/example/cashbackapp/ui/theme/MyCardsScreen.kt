package com.example.cashbackapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cashbackapp.domain.CardItem
import com.example.cashbackapp.ui.theme.OptionScreen.CardGridType
import com.example.cashbackapp.ui.theme.OptionScreen.CardGridType.ONE_ROW
import com.example.cashbackapp.ui.theme.OptionScreen.CardGridType.TWO_ROW

@Composable
fun MyCardsScreen(viewModel: MyCardsViewModel) {

    val screenState = viewModel.screenState.observeAsState(MyCardsScreenState.Initial)

    when (val currentState = screenState.value) {
        is MyCardsScreenState.MyCardPosts -> {
            Column {
                HeaderWithSearch()

                MyCardsItems(
                    viewModel = viewModel, cards = currentState.myCardPosts, cardGridType = TWO_ROW
                )
            }

        }

        MyCardsScreenState.Initial -> {

        }
    }


}

@Composable
fun MyCardsItems(
    viewModel: MyCardsViewModel,
    cards: List<CardItem>,
    cardGridType: CardGridType
) {


    when (cardGridType) {

        ONE_ROW -> {
            OneRowGrid(cards = cards)
        }

        TWO_ROW -> {
            TwoRowGrid(cards = cards)
        }

    }


}

@Composable
fun OneRowGrid(

    cards: List<CardItem>,

    ) {
    Card(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = cards,
                key = { it.id }
            ) { cardItem ->

                // нужно повесить лисенеры кликов туть

                PostCard(cardItem = cardItem)
            }
        }
    }
}

@Composable
fun TwoRowGrid(

    cards: List<CardItem>,

    ) {
    Card(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
        modifier = Modifier.fillMaxSize()
    ) {


        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(
                items = cards,
            ) { cardItem ->
                PostCard(cardItem = cardItem)

            }

        }
    }
}



