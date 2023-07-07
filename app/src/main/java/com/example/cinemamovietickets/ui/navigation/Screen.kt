package com.example.cinemamovietickets.ui.navigation

import com.example.cinemamovietickets.R

sealed class Screen(
    val title: Int = 0,
    val icon: Int = 0,
    val screen_route: String,
    val badgeCount : Int = 0,
) {
    object Home : Screen(R.string.home, R.drawable.ic_home_movie,  "home")
    object Search : Screen(R.string.search, R.drawable.ic_search, "search")
    object Tickets : Screen(R.string.ticket, R.drawable.ic_ticket, "tickets", 9)
    object Profile : Screen(R.string.profile, R.drawable.ic_profile,  "profile")
    object BookingScreen : Screen(screen_route = "bookingScreen")
    object TicketScreen : Screen(screen_route = "ticketScreen")

}
