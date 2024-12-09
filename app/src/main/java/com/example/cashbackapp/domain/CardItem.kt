package com.example.cashbackapp.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.graphics.vector.ImageVector

class CardItem(
    val id: Int,
    val bankName: String,
    val cardType: String,
    val bankImage: ImageVector = Icons.Default.AccountCircle,
    val cashBack: CashbackItem
)