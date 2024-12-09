package com.example.cashbackapp.navigation

sealed class Screen (
    val route: String
) {
    object MyCards: Screen (ROUTE_MY_CARDS)
    object Partners: Screen (ROUTE_PARTNERS)
    object Options: Screen (ROUTE_OPTIONS)

    companion object {
        const val ROUTE_MY_CARDS = "my_cards"
        const val ROUTE_PARTNERS = "partners"
        const val ROUTE_OPTIONS = "options"
    }
}
