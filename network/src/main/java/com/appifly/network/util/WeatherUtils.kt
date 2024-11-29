package com.appifly.network.util

import android.content.Context

object WeatherUtils {


    fun checkWeatherType(weatherType: Int?): String {
        return when (weatherType) {
            in 0..10 -> "Sunny"
            in 10..30 -> "Mostly Sunny"
            in 30..50 -> "Partly Cloudy"
            in 50..70 -> "Mostly Cloudy"
            in 70..100 -> "Overcast"
            else -> {
                "Invalid Data"
            }
        }
    }

    fun kelvinToCelsius(temp: Double): Double {
        return (temp - 273.15).toBigDecimal().setScale(2, java.math.RoundingMode.HALF_UP).toDouble()
    }


    fun getIconUrl(icon:String):String{
        return  "https://openweathermap.org/img/wn/${icon}@4x.png"
    }

    fun loadJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}