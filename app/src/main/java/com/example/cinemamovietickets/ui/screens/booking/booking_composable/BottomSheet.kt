package com.example.cinemamovietickets.ui.screens.booking.booking_composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.composable.ImageButton
import com.example.cinemamovietickets.ui.composable.OutlineButton
import com.example.cinemamovietickets.ui.composable.verticalSpacer.VerticalSpacer32
import com.example.cinemamovietickets.ui.theme.Orange80

@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color.White)
    ) {
        BottomSheetContent(onButtonClicked = {onButtonClicked()})
    }
}

@Preview
@Composable
fun PreviewBottomSheet() {
    BottomSheet(onButtonClicked = {})
}

@Composable
private fun BottomSheetContent(onButtonClicked: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    MovieTextDetails(title = "6.8/10", subtitle = "IMDb")
                    MovieTextDetails(title = "63%", subtitle = "Rotten Tomatoes")
                    MovieTextDetails(title = "4/10", subtitle = "IGN")
                }

                Text(modifier = Modifier.padding(top = 16.dp),
                    text = "Fantastic Beasts: The\nSecrets of Dumbledore",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlineButton(text = "Fantasy") {}
            OutlineButton(modifier = Modifier.padding(start = 8.dp), text = "Adventure") {}
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(32.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(20) { ActorItem(imageUrl = "https://media.gettyimages.com/id/693134468/photo/the-mummy-new-york-fan-event.jpg?s=2048x2048&w=gi&k=20&c=6L_XI88pHPaEmb2mNo9J6Yy_xDrJ3EiCYhe0wOZC66w=") }
        }

        Column(
            modifier = Modifier.padding(start = 32.dp, end = 16.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.movie_description),
                fontSize = 12.sp,
                lineHeight = 15.sp
            )

            VerticalSpacer32()

            ImageButton(
                painter = R.drawable.ic_calendar,
                backgroundColor = Orange80,
                text = "Booking",
                textSize = 16
            ) {
                onButtonClicked()
            }
        }
    }
}
