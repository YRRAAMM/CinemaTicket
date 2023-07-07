package com.example.cinemamovietickets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.cinemamovietickets.ui.composable.BottomNavBar
import com.example.cinemamovietickets.ui.navigation.CinemaMovieTicketsNavGraph
import com.example.cinemamovietickets.ui.theme.CinemaMovieTicketsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaApp() {
    CinemaMovieTicketsTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavBar(navController) }) {
            CinemaMovieTicketsNavGraph(navController = navController, modifier = Modifier.padding(it))
        }
    }
}