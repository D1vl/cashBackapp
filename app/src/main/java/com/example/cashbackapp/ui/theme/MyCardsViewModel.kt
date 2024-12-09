package com.example.cashbackapp.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cashbackapp.domain.CardItem
import com.example.cashbackapp.domain.CashbackItem
import com.example.cashbackapp.ui.theme.OptionScreen.CardGridType

class MyCardsViewModel : ViewModel() {

    val fakeCard = CashbackItem(
        iconType = Icons.Default.AccountCircle,
        nameType = "Credit card",
        cashbackQuantity = "5%"
    )

    private val sourceList = mutableListOf<CardItem>().apply {
        repeat(5) {
            add(
                CardItem(
                    id = it,
                    bankName = "Sber",
                    cardType = "credit",
                    cashBack = fakeCard
                )
            )
        }
    }

    private val initialState = MyCardsScreenState(myCardPosts = sourceList)

    private val _screenState = MutableLiveData(initialState)
    val screenState: LiveData<MyCardsScreenState> = _screenState


    // Сделать функцию для выбора типа отображения карточки
    fun selectGridType(
        cardGridType: CardGridType
    ) {
        _screenState.value = initialState.copy(gridSettings = cardGridType)
    }
}