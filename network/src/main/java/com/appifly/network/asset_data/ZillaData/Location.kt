package com.appifly.network.asset_data.ZillaData

import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class Location(
    val id: Long,
    val name: String,
    val state: String,
    val country: String,
    val coord: Coord
)

@Serializable
data class Coord(
    val lon: Double,
    val lat: Double
)