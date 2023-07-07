package com.example.cinemamovietickets.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinemamovietickets.ui.composable.verticalSpacer.VerticalSpacer32
import com.example.cinemamovietickets.ui.screens.booking.navigateToBookingScreen
import com.example.cinemamovietickets.ui.screens.home.home_composable.HomeBackgroundImage
import com.example.cinemamovietickets.ui.screens.home.home_composable.HomeHeader
import com.example.cinemamovietickets.ui.screens.home.home_composable.MovieDetails
import com.example.cinemamovietickets.ui.screens.home.home_composable.MoviePager
import com.example.cinemamovietickets.viewmodels.home.HomeUIState
import com.example.cinemamovietickets.viewmodels.home.HomeViewModel

// todo handle the MovieDetails it already has the state

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    HomeContent(state = state, pagerState = pagerState) {id ->
        navController.navigateToBookingScreen(id)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: HomeUIState,
    pagerState: PagerState,
    onItemClickListener: (id: Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        HomeBackgroundImage(state, pagerState)

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.LightGray,
                strokeWidth = 5.dp
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                VerticalSpacer32()

                HomeHeader()
            }

            item {
                MoviePager(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 16.dp), state = state, pagerState = pagerState) {
                    onItemClickListener(state.movies[pagerState.currentPage].id)
                }
            }
            item {
                MovieDetails(state, pagerState)
                VerticalSpacer32()
            }
        }
    }
}



@Preview
@Composable
fun PreviewHomeScreen() {

}