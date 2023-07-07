package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.navigation.Screen
import com.example.cinemamovietickets.ui.theme.Orange80

@Composable
fun BottomNavBar(navController: NavHostController) {
    val current = navController.currentBackStackEntryAsState()
    val selectedScreen = current.value?.destination?.route ?: Screen.Home.screen_route
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White)
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ImageButton(
            painter = R.drawable.ic_home_movie,
            modifier = Modifier.size(48.dp),
            iconTint = if (selectedScreen == Screen.Home.screen_route) Color.White else Color.Gray,
            backgroundColor = if (selectedScreen == Screen.Home.screen_route) Orange80 else Color.Transparent
        ) {
            navController.navigate(Screen.Home.screen_route)
        }
        ImageButton(
            painter = R.drawable.ic_search,
            modifier = Modifier.size(48.dp),
            iconTint = Color.Gray,
            backgroundColor = Color.Transparent
        ) {}
        ImageButton(
            painter = R.drawable.ic_ticket,
            modifier = Modifier.size(48.dp),
            iconTint = if (selectedScreen == Screen.Home.screen_route) Color.White else Color.Gray,
            backgroundColor = if (selectedScreen== Screen.Home.screen_route) Orange80 else Color.Transparent
        ) {
            navController.navigate(Screen.Home.screen_route)
        }
        ImageButton(
            painter = R.drawable.ic_profile,
            modifier = Modifier.size(48.dp),
            iconTint = Color.Gray,
            backgroundColor = Color.Transparent
        ) {}
    }
}

