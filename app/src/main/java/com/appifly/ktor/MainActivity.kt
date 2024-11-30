package com.appifly.ktor

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appifly.ktor.route.HomeScreen
import com.appifly.ktor.route.SELECTED_KEY
import com.appifly.ktor.route.SearchScreen
import com.appifly.ktor.ui.screen.HomeScreen
import com.appifly.ktor.ui.screen.SearchScreen
import com.appifly.ktor.ui.theme.KtorTheme
import com.appifly.network.R
import com.appifly.network.asset_data.zilla_data.Location
import kotlinx.serialization.json.Json
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = "HomeScreen"
                        ) {
                            composable("HomeScreen"){backStackEntry->
                               val data= backStackEntry.savedStateHandle.get<String>(SELECTED_KEY)
                                val location= data?.let { Json.decodeFromString<Location>(it) }
                                HomeScreen(navController = navController, location = location)
                            }

                            composable("SearchScreen") {backStackEntry->
                                SearchScreen(navController = navController)
                            }
                        }

                    }
                }
            }
        }
    }
}


