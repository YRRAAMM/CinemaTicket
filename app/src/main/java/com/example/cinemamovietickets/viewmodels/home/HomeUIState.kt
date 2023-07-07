package com.example.cinemamovietickets.viewmodels.home

import com.example.cinemamovietickets.data.model.MoviesModule

data class HomeUIState(
    val movies: List<MoviesModule> = emptyList(),
    val isLoading: Boolean = false,
    val error: Boolean = false,
)