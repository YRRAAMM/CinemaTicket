package com.example.cinemamovietickets.ui.screens.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cinemamovietickets.ui.composable.ExitIcon
import com.example.cinemamovietickets.ui.screens.ticket.ticket_composable.BottomSheet
import com.example.cinemamovietickets.ui.screens.ticket.ticket_composable.CinemaChairs
import com.example.cinemamovietickets.ui.screens.ticket.ticket_composable.CircleWithText
import com.example.cinemamovietickets.ui.screens.ticket.ticket_composable.TicketHeader
import com.example.cinemamovietickets.ui.theme.BlackBackground
import com.example.cinemamovietickets.ui.theme.Gray
import com.example.cinemamovietickets.ui.theme.Orange80
import com.example.cinemamovietickets.viewmodels.booking.BookingViewModel
import com.example.cinemamovietickets.viewmodels.ticket.TicketUIState
import com.example.cinemamovietickets.viewmodels.ticket.TicketViewModel

// todo fix the bottom sheet
// todo fix the chairs
// todo fix the sizes
// todo handle the nav
// todo take the data items and logic from the old project
// todo handle the states

@Composable
fun TicketScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: TicketViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    TicketContent(state, modifier)
}

@Composable
fun TicketContent(
    state: TicketUIState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackBackground)
    ) {
        ExitIcon() {

        }
        TicketHeader(state)
        CinemaChairs()

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CircleWithText(text = "Available", circleTint = Color.White)
            CircleWithText(text = "Taken", circleTint = Gray)
            CircleWithText(text = "Selected", circleTint = Orange80)
        }
        Spacer(modifier = Modifier.weight(1f))

        BottomSheet()
    }


}

@Preview
@Composable
fun PreviewTicketContent() {

}