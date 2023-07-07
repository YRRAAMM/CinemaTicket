package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.ui.theme.Gray

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textSize: Int = 14,
    buttonColor: Color = Color.Transparent,
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        border = BorderStroke(0.5.dp, Gray),
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        Text(
            text = text,
            fontSize = textSize.sp,
            color = textColor
        )
    }
}