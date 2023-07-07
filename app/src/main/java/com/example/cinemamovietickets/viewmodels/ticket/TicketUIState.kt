package com.example.cinemamovietickets.viewmodels.ticket

data class TicketUIState(
    val image : String = "",
    val isLoading: Boolean = false,
    val error: String = "",
)