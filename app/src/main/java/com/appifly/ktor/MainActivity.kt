package com.appifly.ktor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appifly.ktor.route.HomeScreen
import com.appifly.ktor.route.SearchScreen
import com.appifly.ktor.ui.screen.HomeScreen
import com.appifly.ktor.ui.screen.SearchScreen
import com.appifly.ktor.ui.theme.KtorTheme
import com.appifly.ktor.viewmodel.CategoryViewModel
import org.koin.androidx.compose.navigation.koinNavViewModel

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
                            startDestination = HomeScreen
                        ) {
                            composable<HomeScreen> {
                                HomeScreen()
                            }

                            composable<SearchScreen> {
                                SearchScreen()
                            }
                        }

                    }
                }
            }
        }
    }
}


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        KtorTheme {
            // Greeting("Android")
        }
    }