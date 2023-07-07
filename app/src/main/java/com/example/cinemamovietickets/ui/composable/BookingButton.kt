package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.R
import com.example.cinemamovietickets.ui.theme.Orange80

@Composable
fun OrangeButton(stringId: Int, onClickEvent: () -> Unit) {
    Button(
        onClick = onClickEvent, modifier = Modifier
            .height(55.dp)
            .background(Orange80, RoundedCornerShape(100.dp)),
        colors = ButtonDefaults.buttonColors(Orange80)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_calendar),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.background(Orange80)
        )
        Text(
            text = stringResource(stringId),
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}