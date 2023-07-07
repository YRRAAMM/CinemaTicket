package com.example.cinemamovietickets.ui.screens.reserved_tickets

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.cinemamovietickets.ui.navigation.Screen


fun NavController.navigateBookedTicket() {
    popBackStack(Screen.Tickets.screen_route, true)
    navigate(ROUTE_TICKET)
}

private const val ROUTE_TICKET = "tickets"
fun NavGraphBuilder.bookedTicketsRoute(navController: NavController) {
    composable(route = ROUTE_TICKET) {
        BookedTicketsScreen(navController = navController)
    }
}