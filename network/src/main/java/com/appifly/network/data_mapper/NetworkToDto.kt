package com.appifly.network.data_mapper

import com.appifly.network.data_object_model.WeatherDto
import com.appifly.network.remote_data.model.weather.WeatherResponse
import com.appifly.network.util.WeatherUtils


fun WeatherResponse.toDto(): WeatherDto {

    return WeatherDto(
        temp = WeatherUtils.kelvinToCelsius(main?.temp ?: 0.0),
        feelLike = main?.feelsLike,
        weatherType = WeatherUtils.checkWeatherType(clouds?.all),
        icon = WeatherUtils.getIconUrl(weather?.get(0)?.icon ?: ""),
    )
}