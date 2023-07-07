package com.example.cinemamovietickets.ui.screens.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cinemamovietickets.ui.navigation.Screen

fun NavController.navigateProfile() {
    popBackStack(Screen.Profile.screen_route, true)
    navigate(ROUTE_PROFILE)
}

private const val ROUTE_PROFILE = "profile"
fun NavGraphBuilder.profileRoute(navController: NavController) {
    composable(route = ROUTE_PROFILE) {
        ProfileScreen(navController = navController)
    }
}