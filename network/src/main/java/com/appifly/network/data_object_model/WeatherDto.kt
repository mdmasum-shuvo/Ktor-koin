package com.appifly.network.data_object_model

import androidx.compose.runtime.Immutable

@Immutable
data class WeatherDto(
    val temp: Double?,
    val feelLike: Double?,
    val weatherType: String?,
    val icon: String?
)
