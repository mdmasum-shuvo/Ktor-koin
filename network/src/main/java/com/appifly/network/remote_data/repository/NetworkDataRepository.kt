package com.appifly.network.remote_data.repository

import com.appifly.network.data_object_model.WeatherDto
import com.appifly.network.remote_data.model.category.CategoryResponse

interface NetworkDataRepository {

    suspend fun getAllCategory(lat:Double,lnf:Double):Result<WeatherDto>

}