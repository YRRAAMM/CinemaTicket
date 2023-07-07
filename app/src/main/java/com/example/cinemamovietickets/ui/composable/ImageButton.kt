package com.example.cinemamovietickets.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemamovietickets.ui.composable.horizonatalSpacers.CustomHorizontalSpacer
import com.example.cinemamovietickets.ui.theme.LightWhite
import com.example.cinemamovietickets.ui.theme.OrangeLight
import com.example.cinemamovietickets.ui.theme.TextWhite


@Composable
fun ImageButton(
    painter: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = LightWhite,
    iconTint: Color = Color.White,
    text: String = "",
    textSize: Int = 16,
    badgeNumber: Int = 0,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(color = backgroundColor)
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(painter),
                contentDescription = "$text button",
                tint = iconTint
            )
            if (badgeNumber > 0) {
                CustomHorizontalSpacer(size = 4)
                BadgeCircle(modifier = Modifier.align(Alignment.TopEnd), circleTint = OrangeLight, badgeNumber = badgeNumber)
            }
        }

        if (text.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = text,
                fontSize = textSize.sp,
                color = TextWhite
            )
        }
    }
}