package com.example.cinemamovietickets.viewmodels.booking

data class BookingUIState(
    val imageId: Int = 0,
    val image : String = "",
    val isLoading: Boolean = false,
    val error: String = "",
)