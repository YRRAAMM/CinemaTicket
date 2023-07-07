package com.example.cinemamovietickets.ui.screens.home.home_composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinemamovietickets.ui.screens.home.HomeUIState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBackgroundImage(state: HomeUIState, pagerState: PagerState) {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .blur(40.dp),
        contentScale = ContentScale.Crop,
        painter = rememberAsyncImagePainter(model = state.movies[pagerState.currentPage].imageUrl),
        contentDescription = ""
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color.White,
                        Color.White
                    )
                )
            )
    )
}
