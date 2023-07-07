package com.example.cinemamovietickets.ui.screens.ticket.ticket_composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.ui.theme.Gray

@Composable
fun DateItem(
    date: String,
    day: String = "Thu",
    isSelected: Boolean,
    onItemSelectedListener: (date: String) -> Unit
) {

    Column(
        modifier = Modifier
            .size(56.dp, 65.dp)
            .clip(RoundedCornerShape(18.dp))
            .clickable { onItemSelectedListener(date) }
            .background(if (isSelected) Gray else Color.Transparent)
            .border(0.1.dp, Gray, RoundedCornerShape(18.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = date,
            fontSize = 14.sp,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier.padding(top = 8.dp, end = 16.dp, start = 16.dp)
        )
        Text(
            text = day,
            color = if (isSelected) Color.White else Gray,
            fontSize = 14.sp,
        )
    }
}

@Preview
@Composable
fun PreviewDateItem() {
    DateItem(date = "1", isSelected = false, onItemSelectedListener = {})
    
}