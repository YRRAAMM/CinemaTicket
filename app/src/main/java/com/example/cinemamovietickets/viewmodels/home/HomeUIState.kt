package com.example.cinemamovietickets.viewmodels.home

import com.example.cinemamovietickets.data.model.MoviesModel

data class HomeUIState(
    val movies: List<MoviesModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)