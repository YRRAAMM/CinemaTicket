package com.example.cinemamovietickets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cinemamovietickets.ui.composable.BottomNav
import com.example.cinemamovietickets.ui.composable.ImageButton
import com.example.cinemamovietickets.ui.composable.verticalSpacer.VerticalSpacer16
import com.example.cinemamovietickets.ui.composable.verticalSpacer.VerticalSpacer8
import com.example.cinemamovietickets.ui.navigation.CinemaMovieTicketsNavGraph
import com.example.cinemamovietickets.ui.navigation.Screen
import com.example.cinemamovietickets.ui.theme.CinemaMovieTicketsTheme
import com.example.cinemamovietickets.ui.theme.Orange80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaMovieTicketsApp() {
    val navController = rememberNavController()
    CinemaMovieTicketsTheme {

        Scaffold(

            bottomBar = {
                val visibility = currentRoute(navController) in listOf(
                    Screen.Home.screen_route,
                    Screen.Search.screen_route,
                    Screen.Tickets.screen_route,
                    Screen.Profile.screen_route,
                )
                BottomBar(navController, visibility)
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                CinemaMovieTicketsNavGraph(navController = navController)
            }

        }
    }
}


@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


@Composable
private fun BottomBar(navController: NavHostController, visibility: Boolean) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.screen_route } == true
    NavigationBarItem(
        selected = selected,
//      label = { MarqueeText(title = stringResource(id = screen.title))},
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
                        navController.graph.startDestinationRoute?.let { screen_route ->
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
                        navController.graph.startDestinationRoute?.let { screen_route ->
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
                navController.graph.startDestinationRoute?.let { screen_route ->
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
