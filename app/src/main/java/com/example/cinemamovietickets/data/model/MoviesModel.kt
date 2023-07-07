package com.example.cinemamovietickets.data.model

data class MoviesModel(
    val id: Int,
    val imageUrl: String,
    val movieName: String,
    val movieTime: String,
    val movieTypes: List<String>,
)
