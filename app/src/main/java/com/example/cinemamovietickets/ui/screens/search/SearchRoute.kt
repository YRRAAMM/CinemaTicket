package com.example.cinemamovietickets.ui.screens.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cinemamovietickets.ui.navigation.Screen

fun NavController.navigateSearch() {
    popBackStack(Screen.Search.screen_route, true)
    navigate(ROUTE_SEARCH)
}

private const val ROUTE_SEARCH = "search"
fun NavGraphBuilder.searchRoute(navController: NavController) {
    composable(route = ROUTE_SEARCH) {
        SearchScreen(navController = navController)
    }
}