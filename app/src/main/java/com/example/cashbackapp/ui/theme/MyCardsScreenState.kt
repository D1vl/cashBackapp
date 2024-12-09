package com.example.cashbackapp.ui.theme

import com.example.cashbackapp.domain.CardItem
import com.example.cashbackapp.ui.theme.OptionScreen.CardGridType

data class MyCardsScreenState(
    val myCardPosts: List<CardItem> = emptyList(),
    val gridSettings: CardGridType = CardGridType.ONE_ROW
) {
//    object Initial: MyCardsScreenState()
//    data class MyCardPosts(val myCardPosts: List<CardItem>) : MyCardsScreenState()
}