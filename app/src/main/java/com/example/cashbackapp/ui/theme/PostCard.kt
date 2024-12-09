package com.example.cashbackapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cashbackapp.domain.CardItem

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    cardItem: CardItem
) {
    Card(
        modifier = Modifier
            .width(176.dp)
            .height(121.dp)
    ) {

        Row()
        {
            Image(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 8.dp),
                imageVector = Icons.Default.AccountCircle, contentDescription = ""
            )
            Column {
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = cardItem.bankName
                )
                Text(text = cardItem.cardType)
            }
        }
        Row(
            modifier = Modifier.padding(start = 10.dp, top = 38.dp)
        ) {
            Image(imageVector = cardItem.cashBack.iconType, contentDescription = "")
            Text(text = cardItem.cashBack.cashbackQuantity)

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderWithSearch() {
    Column {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")

            }
            Text(modifier = Modifier.padding(),
                text = "My cards")
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "")

            }
        }
        SearchBar(query = "Search", onQueryChange = {}, onSearch = {}, active = false, onActiveChange = {}, modifier = Modifier.fillMaxWidth() ) {

        }
    }



}