package com.example.cinemamovietickets.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cinemamovietickets.R

@Composable
fun ExitIcon(
    modifier: Modifier = Modifier,
    onClickExit: () -> Unit
) {
    ImageButton(modifier = modifier, painter = R.drawable.ic_exit) { onClickExit() }
}