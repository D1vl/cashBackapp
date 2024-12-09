package com.example.cashbackapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.HomeScreenNavGraph(
    myCardsScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = Screen.MyCards.route,
        route = Screen.MyCards.route
    ) {
        composable(Screen.MyCards.route) {
            myCardsScreenContent()
        }
        // dobavit "partners" "options"
    }
}