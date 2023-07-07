package com.example.cinemamovietickets.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cinemamovietickets.ui.composable.BottomBar
import com.example.cinemamovietickets.ui.navigation.CinemaMovieTicketsNavGraph
import com.example.cinemamovietickets.ui.navigation.Screen
import com.example.cinemamovietickets.ui.theme.CinemaMovieTicketsTheme

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

