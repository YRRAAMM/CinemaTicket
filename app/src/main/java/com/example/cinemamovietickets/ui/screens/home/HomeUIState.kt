package com.example.cinemamovietickets.ui.screens.home

import com.example.cinemamovietickets.data.model.MoviesModel

data class HomeUIState(
    val movies: List<MoviesModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)