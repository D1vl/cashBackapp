package com.example.cashbackapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cashbackapp.navigation.AppNavGraph
import com.example.cashbackapp.navigation.rememberNavigationState
import com.example.cashbackapp.ui.theme.OptionScreen.OptionScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MyCardsViewModel) {
    val navigationState = rememberNavigationState()
    Scaffold(
        topBar = {},
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val items = listOf(
                    NavigationItem.MyCards,
                    NavigationItem.Partners,
                    NavigationItem.Options
                )
                items.forEach { item ->
                    val selected = navBackStackEntry?.destination?.hierarchy?.any {
                        it.route == item.screen.route
                    } ?: false

                    NavigationBarItem(selected = selected,
                        onClick = {
                            if (!selected) {
                                navigationState.navigateTo(item.screen.route)
                            }
                        },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        }
                    )
                }
            }

        },
    ) {
        AppNavGraph(
            navHostController = navigationState.navHostController,
            myCardsScreenContent = {
                MyCardsScreen(viewModel)
            },
            partnersScreenContent = { /*TODO*/ },
            optionScreenContent = {
                OptionScreen(
                    viewModel = viewModel,
                    onBackPressed = {
                        navigationState.navHostController.popBackStack()

                    }
                )
            }
        )
    }
}

//@Composable
//fun CashBackItem(): CashbackItem {
//    Row(
//        modifier = Modifier.padding(start = 10.dp, top = 38.dp)
//    ) {
//        Image(imageVector = t, contentDescription = "")
//        Text(text = "%")
//    }
//}