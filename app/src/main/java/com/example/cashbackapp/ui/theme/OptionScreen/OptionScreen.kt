package com.example.cashbackapp.ui.theme.OptionScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionScreen(
    onBackPressed: () -> Unit,

    ) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Options")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack, contentDescription = ""
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues) ) {
            CardsRowOption()
        }
    }
}