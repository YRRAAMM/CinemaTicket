package com.example.cinemamovietickets.ui.screens.ticket.ticket_composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.theme.Gray

@Composable
fun CinemaChairs() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        columns = GridCells.Fixed(count = 3)
    ) {
        items(9) { index->
            when (index % 3) {
                0 -> ChairItem(10f)
                1 -> ChairItem(0f, 10f)
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
                .size(50.dp)
                .padding(start = 8.dp, end = 2.dp)
                .constrainAs(chair1) {
                    bottom.linkTo(container.bottom, margin = 8.dp)
                    start.linkTo(container.start)
                },
            painter = painterResource(id = R.drawable.chair),
            contentDescription = "Chair",
            tint = Color.White
        )
        Icon(
            modifier = Modifier
                .size(50.dp)
                .padding(start = 2.dp, end = 8.dp)
                .constrainAs(chair2) {
                    bottom.linkTo(container.bottom,  margin = 8.dp)
                    end.linkTo(container.end)
                },
            painter = painterResource(id = R.drawable.chair),
            contentDescription = "Chair",
            tint = Color.White
        )

        Icon(
            modifier = Modifier
                .size(100.dp)
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


