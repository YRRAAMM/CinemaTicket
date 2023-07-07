package com.example.cinemamovietickets.viewmodels.ticket.uistate

data class TicketUIState(
    val image : String = "",
    val isLoading: Boolean = false,
    val error: String = "",
    val timeList: List<String> = listOf(
        "10:00",
        "12:30",
        "15:30",
        "18:00",
        "18:30",
        "19:00",
        "20:00",
    )
)