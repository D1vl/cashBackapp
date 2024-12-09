package com.example.cashbackapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    myCardsScreenContent: @Composable () -> Unit,
    partnersScreenContent: @Composable () -> Unit,
    optionScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.MyCards.route,
    ) {
        composable(Screen.MyCards.route) {
            myCardsScreenContent()
        }
        composable(Screen.Options.route) {
            optionScreenContent()
        }
        composable(Screen.Partners.route) {
            partnersScreenContent()
        }

    }
}