package com.example.cinemamovietickets.ui.screens.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import coil.compose.rememberAsyncImagePainter
import com.example.cinemamovietickets.ui.composable.ExitIcon
import com.example.cinemamovietickets.ui.navigation.Screen
import com.example.cinemamovietickets.ui.screens.ticket.ticket_composable.BottomSheet
import com.example.cinemamovietickets.ui.screens.ticket.ticket_composable.CinemaChairs
import com.example.cinemamovietickets.ui.screens.ticket.ticket_composable.ChairState
import com.example.cinemamovietickets.ui.theme.BlackBackground
import com.example.cinemamovietickets.ui.theme.Gray
import com.example.cinemamovietickets.ui.theme.Orange80
import com.example.cinemamovietickets.viewmodels.ticket.uistate.TicketUIState
import com.example.cinemamovietickets.viewmodels.ticket.TicketViewModel

@Composable
fun TicketScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: TicketViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    TicketContent( modifier, state) {
        navController.popBackStack(Screen.Home.screen_route, false)
    }
}

@Composable
fun TicketContent(
    modifier: Modifier = Modifier,
    state: TicketUIState,
    onExitClicked: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackBackground)
    ) {

        Spacer(modifier = Modifier.weight(1f))

        ExitIcon(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            onExitClicked()
        }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxHeight(0.15f),
            painter = rememberAsyncImagePainter(model = state.image),
            contentDescription = "Header Image",
        )
        
        CinemaChairs()

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ChairState(text = "Available", circleTint = Color.White)
            ChairState(text = "Taken", circleTint = Gray)
            ChairState(text = "Selected", circleTint = Orange80)
        }

        BottomSheet(state)

    }


}

@Preview
@Composable
fun PreviewTicketContent() {

}