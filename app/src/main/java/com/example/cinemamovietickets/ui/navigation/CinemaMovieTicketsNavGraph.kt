package com.example.cinemamovietickets.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.cinemamovietickets.ui.screens.booking.bookingRoute
import com.example.cinemamovietickets.ui.screens.home.homeRoute
import com.example.cinemamovietickets.ui.screens.profile.profileRoute
import com.example.cinemamovietickets.ui.screens.reserved_tickets.bookedTicketsRoute
import com.example.cinemamovietickets.ui.screens.search.searchRoute
import com.example.cinemamovietickets.ui.screens.ticket.ticketRoute

@Composable
fun CinemaMovieTicketsNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.screen_route
    ) {
        // add your routes here
        homeRoute(navController = navController)
        profileRoute(navController = navController)
        searchRoute(navController = navController)
        bookedTicketsRoute(navController = navController)
        bookingRoute(navHostController = navController)
        ticketRoute(navHostController = navController)
    }
}

fun NavController.showingBack(): Boolean {
    return when (this.currentBackStackEntry?.destination?.route) {
        Screen.Profile.screen_route,
        Screen.Search.screen_route,
        Screen.Tickets.screen_route,
        Screen.Home.screen_route -> false
        else -> true
    }
}