package com.appifly.ktor.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appifly.ktor.route.SELECTED_KEY
import com.appifly.ktor.ui.component.ImageNormal
import com.appifly.ktor.ui.component.LocationFieldWithIcon
import com.appifly.ktor.ui.component.Spacer16DPH
import com.appifly.ktor.ui.component.TextView16_W400
import com.appifly.ktor.ui.component.TextView24_W500
import com.appifly.ktor.ui.component.TextView68_W700
import com.appifly.ktor.ui.theme.Purple40
import com.appifly.ktor.ui.theme.Purple80
import com.appifly.ktor.ui.theme.white_color
import com.appifly.ktor.viewmodel.HomeViewModel
import com.appifly.network.asset_data.zilla_data.Location
import com.appifly.network.util.WeatherUtils
import com.google.android.gms.maps.model.LatLng
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel(),
    navController: NavController,
    location: Location?
) {
    val context = LocalContext.current


    LaunchedEffect(location) {
        if (location != null && location.coord?.lat != null && location.coord?.lon != null) {
            homeViewModel.fetchAllCategory(LatLng(location.coord?.lat!!, location.coord?.lon!!))
            homeViewModel.setLocationName(location.name ?: "")
        }
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
            Row {
                LocationFieldWithIcon(
                    title = "Selected Location", onLocationSelected = { latLng ->
                        homeViewModel.fetchAllCategory(latLng)
                        homeViewModel.setLocationName(
                            WeatherUtils.getAddressFromLatLong(
                                context,
                                latLng.latitude,
                                longitude = latLng.longitude
                            )
                        )
                    }
                )
            }
            Spacer16DPH()
            homeViewModel.categoryList.observeAsState().value?.let { data ->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.LocationOn, contentDescription = "Icon", tint = white_color)
                    TextView24_W500(
                        value = homeViewModel.selectedLocationName.observeAsState().value ?: "",
                        color = white_color
                    )
                }
                Spacer16DPH()
                ImageNormal(data.icon ?: "")
                Spacer16DPH()
                TextView68_W700(
                    value = "${data.temp ?: ""}°C",
                    color = white_color
                )
                TextView24_W500(
                    value = data.weatherType ?: "",
                    color = white_color
                )

                Spacer16DPH()

                Button(onClick = {
                    navController.navigate("SearchScreen")
                }) {
                    TextView16_W400(value = "Search Location", color = white_color)
                }
            }


        }
    }
}

