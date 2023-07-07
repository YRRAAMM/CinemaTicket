package com.example.cinemamovietickets.data.datasource.local.fake

import com.example.cinemamovietickets.data.model.MoviesModel

object MoviesData {
    fun newShowingMovies(): List<MoviesModel> {
        return listOf(
            MoviesModel(
                id = 0,
                imageUrl = "https://www.chicklit.nl/ckfinder/userfiles/images/Chicklit/artikelen/Films/Fantastic%20Beasts-%20The%20Secrets%20of%20Dumbledore%20-%20Dumbledore.jpeg",
                movieName = "Fantastic Beasts: The\nSecrets of Dumbledore",
                movieTime = "2h 23m",
                movieTypes = listOf("Fantasy", "Adventure"),
            ),
            MoviesModel(
                id = 1,
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_FMjpg_UY480_.jpg",
                movieName = "John Wick",
                movieTime = "1h 23m",
                movieTypes = listOf("Action", "Crime", "Thriller"),
            ),
            MoviesModel(
                id = 2,
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMTIzMDc4MzA2Ml5BMl5BanBnXkFtZTcwODU0MzA3MQ@@._V1_FMjpg_UX510_.jpg",
                movieName = "The Dark Knight",
                movieTime = "2h 13m",
                movieTypes = listOf("Action", "Crime", "Drama"),
            ),
            MoviesModel(
                id = 3,
                imageUrl = "https://m.media-amazon.com/images/M/MV5BZTAwMzAxNDEtM2FiNC00ODY2LTk1ZTctOTkyNmJlMmE0Y2IzXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_FMjpg_UY703_.jpg",
                movieName = "Saving Private Ryan",
                movieTime = "5h 23m",
                movieTypes = listOf("Drama", "War"),
            ),
            
        )
    }
}