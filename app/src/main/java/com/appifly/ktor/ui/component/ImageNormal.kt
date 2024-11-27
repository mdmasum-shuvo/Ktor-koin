package com.appifly.ktor.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.appifly.ktor.R

@Composable
fun ImageNormal(
    modifier: Modifier = Modifier.fillMaxSize(),
    drawableId: Int = R.drawable.ic_launcher_background,
    contentScale: ContentScale = ContentScale.None
) {
    Image(
        painterResource(drawableId),
        contentDescription = "logo",
        contentScale = contentScale,
        modifier = modifier,
    )
}