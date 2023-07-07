package com.example.cinemamovietickets.ui.screens.ticket.ticket_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.viewmodels.ticket.TicketUIState

@Composable
fun TicketHeader(state: TicketUIState) {

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp)
            .fillMaxHeight(0.15f),
        painter = rememberAsyncImagePainter(model = state.image),
        contentDescription = "Header Image",
    )
}