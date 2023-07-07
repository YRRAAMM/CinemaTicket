package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinemamovietickets.ui.navigation.Screen
import com.example.cinemamovietickets.ui.theme.Orange80




@Composable
fun BottomBar(navController: NavHostController, visibility: Boolean) {
    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Tickets,
        Screen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    if (visibility) {
        NavigationBar(
            modifier = Modifier.padding(bottom = 8.dp),
            containerColor = Color.White
        ) {
            items.forEach { screen ->

                AddItem(
                    screen = screen,
                    currentDestination = currentRoute,
                    navController = navController
                )
            }
        }
    }
}



@Composable
private fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.screen_route } == true
    NavigationBarItem(
        selected = selected,

        icon = {
            if (screen.badgeCount > 0) {

                ImageButton(
                    painter = screen.icon,
                    modifier = Modifier.size(48.dp),
                    iconTint = if (selected) Color.White else Color.Gray,
                    backgroundColor = if (selected) Orange80 else Color.Transparent,
                    badgeNumber = screen.badgeCount,
                ) {
                    navController.navigate(screen.screen_route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }


            } else {
                ImageButton(
                    painter = screen.icon,
                    modifier = Modifier.size(48.dp),
                    iconTint = if (selected) Color.White else Color.Gray,
                    backgroundColor = if (selected) Orange80 else Color.Transparent,
                ) {
                    navController.navigate(screen.screen_route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        },

        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Transparent,
            unselectedIconColor = Color.Transparent,
            indicatorColor = Color.White
        ),

        onClick = {
            navController.navigate(screen.screen_route) {
                navController.graph.startDestinationRoute?.let {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}
