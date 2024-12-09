package com.example.cashbackapp.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cashbackapp.R
import com.example.cashbackapp.navigation.Screen

sealed class NavigationItem (
    val screen: Screen,
    val titleResId: Int, // тут надо переделать потом на инт и забабахать стринги в ресурсы
    val icon: ImageVector
)
{
    object MyCards: NavigationItem(
        screen = Screen.MyCards,
        titleResId = R.string.navigation_item_myCards,
        icon = Icons.Outlined.Home
    )
    object Partners: NavigationItem(
        screen = Screen.Partners,
        titleResId = R.string.navigation_item_partners,
        icon = Icons.Outlined.Person
    )
    object Options: NavigationItem(
        screen = Screen.Options,
        titleResId = R.string.navigation_item_options,
        icon = Icons.Outlined.Build
    )
}