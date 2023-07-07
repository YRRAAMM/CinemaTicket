package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    tint : Color,
    circleSize : Float = 15f
) {
    Canvas(
        modifier = modifier,
        onDraw = {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawCircle(
                color = tint,
                center = Offset(canvasWidth / 2, canvasHeight / 2),
                radius = circleSize,
            )
        }
    )
}

@Preview
@Composable
fun Preview() {
    Circle(tint = Color.LightGray, modifier = Modifier.padding(12.dp))
}