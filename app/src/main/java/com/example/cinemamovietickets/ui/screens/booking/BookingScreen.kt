package com.example.cinemamovietickets.ui.screens.booking

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cinemamovietickets.ui.navigation.Screen
import com.example.cinemamovietickets.ui.screens.booking.booking_composable.BottomSheet
import com.example.cinemamovietickets.ui.screens.booking.booking_composable.Header
import com.example.cinemamovietickets.ui.screens.ticket.navigateToTicketScreen
import com.example.cinemamovietickets.viewmodels.booking.BookingUIState
import com.example.cinemamovietickets.viewmodels.booking.BookingViewModel

// todo fix the bottom sheet

@Composable
fun BookingScreen(
    navController: NavHostController,
    viewModel: BookingViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    BookingContent(
        state = state,
        closeButton = { navController.popBackStack(Screen.Home.screen_route, false) },
        onClickBuyTickets = {navController.navigateToTicketScreen(state.imageId)}
    )
}

@Composable
private fun BookingContent(state: BookingUIState, closeButton: () -> Unit, onClickBuyTickets: () -> Unit) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (header , bottomSheet) = createRefs()

        Header(
            state = state,
            modifier = Modifier.constrainAs(header){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }. padding(top = 8.dp)
        ) { closeButton() }

        val guideLine = createGuidelineFromTop(0.80f)

        BottomSheet(
            state = state,
            modifier = Modifier.constrainAs(bottomSheet){
                top.linkTo(guideLine)
                bottom.linkTo(parent.bottom)
            },
            onButtonClicked = {
                onClickBuyTickets()
            }

        )
    }
}

@Preview
@Composable
fun PreviewBookingScreen() {

}