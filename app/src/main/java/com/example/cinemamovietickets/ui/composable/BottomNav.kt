package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.navigation.Screen
import com.example.cinemamovietickets.ui.theme.Orange80

@Composable
fun BottomNav(navController: NavHostController, visibility: Boolean) {
    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Tickets,
        Screen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    if (visibility) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background
        ) {
            items.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentRoute,
                    navController = navController
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.screen_route } == true

    val contentColor = if (selected) Color.White else Color.Gray

    val background = if (selected) Orange80.copy(alpha = 0.3f) else Color.Transparent

    Box(
        modifier = Modifier
            .clickable(onClick = {
                navController.navigate(screen.screen_route) {
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ImageButton(
                painter = screen.icon,
                modifier = Modifier.size(48.dp),
                iconTint = if (selected) Color.White else Color.Gray,
                backgroundColor = if (selected) Orange80 else Color.Transparent
            ) {
            }
        }
    }


}
