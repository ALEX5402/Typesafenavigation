package com.android.typesafenavigation.ui

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.android.typesafenavigation.ui.theme.navigation.Routes


@Composable
fun Bottombar(
    navHostController: NavHostController
) {
    val routes = listOf(
        Routes.Home,
        Routes.Messages,
        Routes.Contacts,
    )

    var isSelected by remember {
        mutableIntStateOf(0)
    }

//    val backstackentry = navHostController.currentBackStackEntryAsState()
//    val currentdestination = backstackentry.value?.destination?.route

    BottomAppBar {
        routes.forEachIndexed { index, routes ->
            var correntselection = isSelected == index
            NavigationBarItem(selected = correntselection,
                onClick = {
                    isSelected = index
                         navHostController.navigate(
                             routes.destination
                         ) {

//                             popUpTo(true)
                             launchSingleTop = true
                         }

            }, icon = {
                Icon(routes.icons, contentDescription = null )
            },

                label = {
                    Text(text = routes.title)
                }
            )
        }
    }
}