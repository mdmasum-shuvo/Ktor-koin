package com.appifly.ktor.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appifly.ktor.ui.component.BasicTextField
import com.appifly.ktor.ui.component.ImageNormal
import com.appifly.ktor.ui.component.LocationFieldWithIcon
import com.appifly.ktor.ui.component.Spacer16DPH
import com.appifly.ktor.ui.component.TextFieldWithBorder
import com.appifly.ktor.ui.component.TextView24_W500
import com.appifly.ktor.ui.component.TextView68_W700
import com.appifly.ktor.ui.theme.KtorTheme
import com.appifly.ktor.ui.theme.Purple40
import com.appifly.ktor.ui.theme.Purple80
import com.appifly.ktor.ui.theme.white_color

@Composable
fun HomeScreen() {
    val latitude = remember {
        mutableStateOf("")
    }

    val longitude = remember {
        mutableStateOf("")
    }


    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Purple40, Purple80
                    )
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LocationFieldWithIcon(
                title = "Selected Location",
                latitude = latitude,
                longitude = longitude
            )
            Spacer16DPH()

            Row {
                Icon(Icons.Default.LocationOn, contentDescription = "Icon", tint = white_color)
                TextView24_W500(value = "Dhaka,Bangladesh", color = white_color)
            }
            Spacer16DPH()
            ImageNormal(modifier = Modifier.wrapContentHeight())
            Spacer16DPH()
            TextView68_W700(value = "19°C", color = white_color)
            TextView24_W500(value = "Cloudy", color = white_color)

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {

    KtorTheme {
        HomeScreen()
    }

}