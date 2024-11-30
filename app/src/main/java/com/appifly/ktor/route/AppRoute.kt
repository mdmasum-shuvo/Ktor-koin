package com.appifly.ktor.route

import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen
@Serializable
data object SearchScreen

const val  SELECTED_KEY="selectedLocation"