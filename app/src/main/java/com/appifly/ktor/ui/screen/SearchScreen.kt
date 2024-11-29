package com.appifly.ktor.ui.screen

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.appifly.ktor.ui.component.TextFieldWithBorder
import com.appifly.ktor.ui.theme.white_color
import com.appifly.network.asset_data.ZillaData.Location
import com.appifly.network.util.WeatherUtils
import kotlinx.serialization.json.Json

@Composable
fun SearchScreen() {
    val context=LocalContext.current
    val input = remember {
        mutableStateOf("")
    }

    LaunchedEffect(true) {
        val json =  WeatherUtils.loadJsonFromAssets(context,"Zila.json")
        val locations = Json.decodeFromString<List<Location>>(json)
    }

    Surface(color = white_color) {
        TextFieldWithBorder(inputValue = input, placeholder = "User ID")



    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}