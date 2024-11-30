package com.appifly.ktor.ui.component


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appifly.ktor.R
import com.appifly.ktor.localtion.FindCurrentLocation
import com.appifly.ktor.localtion.LatAndLong
import com.appifly.ktor.ui.theme.KtorTheme
import com.appifly.ktor.ui.theme.Purple40
import com.appifly.ktor.ui.theme.gray_bg
import com.appifly.ktor.ui.theme.light_gray
import com.appifly.ktor.ui.theme.text_gray
import com.appifly.ktor.ui.theme.white_color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay


@Composable
fun LocationFieldWithIcon(
    title: String,
    color: Color =Color.Black,
    placeholder: String = "Latitude, Longitude",
    isBorderEnable: Boolean = true,
    onLocationSelected: (LatLng) -> Unit={}
) {
    // Set properties using MapProperties which you can use to recompose the map
    val mapProperties by remember {
        mutableStateOf(
            MapProperties(maxZoomPreference = 20f, minZoomPreference = 5f)
        )
    }

    val latitude = remember {
        mutableStateOf("")
    }

    val longitude = remember {
        mutableStateOf("")
    }

    val mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(compassEnabled = false, mapToolbarEnabled = false, zoomControlsEnabled = false)
        )
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(23.8103, 90.4125), 15f)  // Center point of Dhaka for initial MapView
    }

    val isLocationClicked = remember { mutableStateOf(false) }
    val currentLatLon = remember { mutableStateOf(LatAndLong()) }

    if (isLocationClicked.value) {
        FindCurrentLocation(currentLatLng1 = currentLatLon)
    }

    LaunchedEffect(key1 = latitude.value, key2 = longitude.value) {
        // checking if location value is changed
        if (currentLatLon.value.latitude != latitude.value.toDoubleOrNull() ||
            currentLatLon.value.longitude != longitude.value.toDoubleOrNull()) {
            isLocationClicked.value = false
        }
    }

    LaunchedEffect(key1 = currentLatLon.value) {
        if (currentLatLon.value.latitude != 0.0 && currentLatLon.value.longitude != 0.0) {
            latitude.value = currentLatLon.value.latitude.toString()
            longitude.value = currentLatLon.value.longitude.toString()

            // update camera position of marker
            cameraPositionState.position = CameraPosition.fromLatLngZoom(LatLng(currentLatLon.value.latitude, currentLatLon.value.longitude), 15f)
        }
    }

    val block: suspend CoroutineScope.() -> Unit = {
        latitude.value = cameraPositionState.position.target.latitude.toString()
        longitude.value = cameraPositionState.position.target.longitude.toString()
        delay(1000)
        onLocationSelected(LatLng(latitude.value.toDouble(), longitude.value.toDouble()))
    }
    LaunchedEffect(cameraPositionState.position.target, block)

    Column {
        Row {
            TextView16_W600(value = title, color = white_color)
        }
        Spacer4DPH()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.height(if (isBorderEnable) 42.dp else 30.dp)
                .wrapContentHeight()
                .clip(if (isBorderEnable) RoundedCornerShape(5.dp) else RectangleShape)
                .border(
                    width = if (isBorderEnable) 1.dp else 0.dp,
                    color = if (isBorderEnable) light_gray else Color.Unspecified,
                    shape = if (isBorderEnable) RoundedCornerShape(5.dp) else RectangleShape
                )
                .background(
                    color = if (isBorderEnable) Color.White else Color.Unspecified,
                    shape = if (isBorderEnable) RoundedCornerShape(5.dp) else RectangleShape
                )
                .padding(
                    horizontal = if (isBorderEnable) 12.dp else 0.dp,
                    vertical = if (isBorderEnable) 10.dp else 0.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextView16_W400(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                value = if (placeholder.isNotEmpty() && latitude.value == "" && longitude.value == "") placeholder else "${latitude.value}, ${longitude.value}",
                color = if (placeholder.isNotEmpty() && latitude.value == "" && longitude.value == "") text_gray else color
            )

            Icon(
                painterResource(id = R.drawable.my_location),
                "contentDescription",
                tint = Purple40,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        isLocationClicked.value = true
                    }
            )

        }
        if(!isBorderEnable) HorizontalDivider(color = gray_bg)

        Spacer12DPH()
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), shape = RoundedCornerShape(5.dp)) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                GoogleMap(
                    cameraPositionState = cameraPositionState,
                    properties = mapProperties,
                    uiSettings = mapUiSettings
                ) {
                    Marker(
                        state = MarkerState(
                            position = cameraPositionState.position.target
                        )
                    )
                }
            }
        }

    }
}

