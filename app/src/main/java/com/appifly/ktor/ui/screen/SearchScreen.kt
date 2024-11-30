package com.appifly.ktor.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appifly.ktor.R
import com.appifly.ktor.route.HomeScreen
import com.appifly.ktor.route.SELECTED_KEY
import com.appifly.ktor.ui.component.Spacer16DPH
import com.appifly.ktor.ui.component.Spacer8DPH
import com.appifly.ktor.ui.component.TextFieldWithBorder
import com.appifly.ktor.ui.component.ZilaItem
import com.appifly.ktor.ui.theme.light_gray
import com.appifly.ktor.viewmodel.SearchViewModel
import com.appifly.network.asset_data.zilla_data.Location
import com.appifly.network.util.WeatherUtils
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(searchViewModel: SearchViewModel = koinViewModel(), navController: NavController) {
    val context = LocalContext.current

    LaunchedEffect(true) {

    }

    Surface(color = light_gray) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextFieldWithBorder(
                placeholder = context.getString(R.string.search),
                onValueChanged = { value ->
                    searchViewModel.filterLocations(value)
                })
            Spacer16DPH()

            searchViewModel.filteredLocationList.observeAsState().value?.let { dataList ->
                LazyColumn {
                    items(
                        dataList,
                        key = { item -> item.id ?: 0 }) { item ->
                        ZilaItem(item.name) {
                            // Pass the result back to HomeScreen using savedStateHandle
                            navController.popBackStack()
                            navController.currentBackStackEntry?.savedStateHandle?.set(SELECTED_KEY, Json.encodeToString(item))

                            // Navigate back to HomeScreen
                           // navController.navigateUp()
                        }
                        Spacer8DPH()
                    }
                }
            }

        }
    }
}
