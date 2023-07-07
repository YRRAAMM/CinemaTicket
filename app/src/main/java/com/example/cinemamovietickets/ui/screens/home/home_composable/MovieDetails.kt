package com.example.cinemamovietickets.ui.screens.home.home_composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.composable.OutlineButton
import com.example.cinemamovietickets.ui.screens.home.HomeUIState

// todo add the states :)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieDetails(state: HomeUIState, pagerState: PagerState) {
    val currentMovie = state.movies[pagerState.currentPage]
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_clock), contentDescription = "clock", modifier = Modifier.padding(end = 8.dp))
        Text(text = currentMovie.movieTime)
    }

    Text(modifier = Modifier.padding(vertical = 16.dp),
        text = currentMovie.movieName,
        fontSize = 22.sp,
        textAlign = TextAlign.Center
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        items(currentMovie.movieTypes) {type ->
            OutlineButton(modifier = Modifier.padding(end = 8.dp), text = type) {}
        }

    }
}
