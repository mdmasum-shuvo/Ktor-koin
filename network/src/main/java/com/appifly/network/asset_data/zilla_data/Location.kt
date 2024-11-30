package com.appifly.network.asset_data.zilla_data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Location(
    val id: Long?,
    val name: String?,
    val state: String?,
    val country: String?,
    val coord: Coord?
) : Parcelable

@Serializable
@Parcelize
data class Coord(
    val lon: Double?,
    val lat: Double?
) : Parcelable