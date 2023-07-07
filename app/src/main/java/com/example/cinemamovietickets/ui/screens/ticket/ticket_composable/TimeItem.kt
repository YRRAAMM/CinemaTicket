package com.example.cinemamovietickets.ui.screens.ticket.ticket_composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.ui.theme.Gray

@Composable
fun TimeItem(
    time: String = "",
    isSelected: Boolean,
    onTimeSelectedListener: (time: String) -> Unit
) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onTimeSelectedListener(time) }
            .background(if (isSelected) Gray else Color.Transparent)
            .border(0.1.dp, Gray, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = time,
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp),
            color = if (isSelected) Color.White else Gray
        )
    }
}