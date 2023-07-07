package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BadgeCircle(
    modifier: Modifier = Modifier,
    badgeNumber: Int = 0,
    circleTint: Color
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Circle(tint = circleTint, circleSize = 20f)
        Text(text = "$badgeNumber", fontSize = 12.sp, color = Color.White)
    }
}