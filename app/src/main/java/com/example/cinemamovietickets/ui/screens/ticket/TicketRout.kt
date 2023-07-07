package com.example.cinemamovietickets.ui.screens.ticket

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cinemamovietickets.ui.navigation.Screen

private val ROUTE = Screen.TicketScreen.screen_route

fun NavController.navigateToTicketScreen(imageId: Int) {
    navigate("$ROUTE/$imageId")
}

fun NavGraphBuilder.ticketRoute(navHostController: NavHostController) {
    composable(
        "$ROUTE/{${TicketArgs.ARG_IMAGE_ID}}",
        arguments = listOf(
            navArgument(TicketArgs.ARG_IMAGE_ID) { NavType.IntType }
        )
    ) { TicketScreen(navController = navHostController) }
}

class TicketArgs(savedStateHandle: SavedStateHandle) {
    val imageId = checkNotNull(savedStateHandle[ARG_IMAGE_ID])

    companion object {
        const val ARG_IMAGE_ID = "imageId"
    }
}