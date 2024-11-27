package com.appifly.ktor.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import com.appifly.ktor.ui.theme.Purple40
import com.appifly.ktor.ui.theme.PurpleGrey40

@Composable
fun gradientColor(): Brush {
    return Brush.horizontalGradient(
        colors = listOf(Purple40, PurpleGrey40)
    )
}