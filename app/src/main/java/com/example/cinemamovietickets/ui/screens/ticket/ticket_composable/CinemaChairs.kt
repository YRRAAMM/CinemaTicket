package com.example.cinemamovietickets.ui.screens.ticket.ticket_composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.theme.Gray
import com.example.cinemamovietickets.ui.theme.Orange80

@Composable
fun CinemaChairs() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(count = 3)
    ) {
        itemsIndexed(
            listOf(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
            )
        ) { index: Int, item: String ->
            when (index % 3) {
                0 -> ChairItem(10f)
                1 -> ChairItem(0f, offset = 9f)
                2 -> ChairItem(-10f)
            }
        }
    }
}


@Composable
private fun ChairItem(
    rotate: Float,
    offset: Float = 0f
) {
    ConstraintLayout(
        modifier = Modifier
            .rotate(rotate)
            .offset(y = offset.dp)
            .size(45.dp)
    ) {
        val (chair1, chair2, container) = createRefs()
        Icon(
            modifier = Modifier
                .size(18.dp)
                .constrainAs(chair1) {
                    bottom.linkTo(container.bottom, margin = 4.dp)
                    start.linkTo(container.start, margin = 4.dp)
                },
            painter = painterResource(id = R.drawable.chair),
            contentDescription = "",
            tint = Orange80
        )
        Icon(
            modifier = Modifier
                .size(18.dp)
                .constrainAs(chair2) {
                    bottom.linkTo(container.bottom, margin = 4.dp)
                    end.linkTo(container.end, margin = 4.dp)
                },
            painter = painterResource(id = R.drawable.chair),
            contentDescription = "",
            tint = Color.White
        )

        Icon(
            modifier = Modifier

                .constrainAs(container) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.chair_place_holder),
            contentDescription = "",
            tint = Gray
        )
    }
}

@Preview
@Composable
fun Chaires () {

    ChairItem(0f, 0f)
}


