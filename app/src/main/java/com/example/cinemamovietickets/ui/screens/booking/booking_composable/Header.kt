package com.example.cinemamovietickets.ui.screens.booking.booking_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.composable.ExitIcon
import com.example.cinemamovietickets.ui.composable.ImageButton
import com.example.cinemamovietickets.ui.theme.Orange80
import com.example.cinemamovietickets.viewmodels.booking.BookingUIState

@Composable
fun Header(
    state: BookingUIState,
    modifier: Modifier = Modifier,
    onClickExit: () -> Unit,
) {
    Box(modifier = modifier.aspectRatio(4f / 5f)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = state.image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop
        )

        Toolbar {
            onClickExit()
        }

        ImageButton(
            painter = R.drawable.ic_play_button,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center),
            backgroundColor = Orange80
        ) {}
    }
}

@Composable
private fun Toolbar(onClickExit: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ExitIcon { onClickExit() }
        ImageButton(painter = R.drawable.ic_clock, text = "2h 23m") {}
    }
}
