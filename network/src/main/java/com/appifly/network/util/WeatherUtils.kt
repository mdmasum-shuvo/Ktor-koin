package com.appifly.network.util

object WeatherUtils {


    fun checkWeatherType(weatherType: Int?): String {
        return when (weatherType) {
            in 0..10 -> "Sunny"
            in 10..30 -> "Mostly Sunny"
            in 30..50 -> "Partly Cloudy"
            in 50..70 -> "Mostly Cloudy"
            in 70..100 -> "Overcast"
            else -> {"Invalid Data"}
        }
    }

}