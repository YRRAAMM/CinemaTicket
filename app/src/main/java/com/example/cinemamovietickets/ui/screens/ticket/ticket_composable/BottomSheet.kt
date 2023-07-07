package com.example.cinemamovietickets.ui.screens.ticket.ticket_composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.composable.ImageButton
import com.example.cinemamovietickets.ui.theme.Gray
import com.example.cinemamovietickets.ui.theme.Orange80

@Composable
fun BottomSheet() {

    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Color.White)
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(top = 32.dp, end = 16.dp, start = 16.dp, bottom = 16.dp)
        ) {
            items((14..31).toList()) { item ->
                DateItem(date = item.toString(), isSelected = selectedDate == item.toString()) { date ->
                    selectedDate = if (selectedDate == date) "" else date
                }
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(listOf("10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30")) { item ->
                TimeItem(time = item, isSelected = selectedTime == item) { date ->
                    selectedTime = if (selectedTime == date) "" else date
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "$100", color = Color.Black, fontSize = 28.sp)
                Text(text = "4 Tickets", color = Gray, fontSize = 12.sp)
            }
            ImageButton(
                painter = R.drawable.ic_calendar,
                backgroundColor = Orange80,
                text = "Buy tickets"
            ) {}
        }
    }
}