package com.example.cinemamovietickets.ui.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cinemamovietickets.ui.navigation.Screen

fun NavController.navigateHome() {
    popBackStack(Screen.Home.screen_route, true)
    navigate(ROUTE_HOME)
}

private const val ROUTE_HOME = "home"
fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(route = ROUTE_HOME) {
        HomeScreen(navController = navController)
    }
}