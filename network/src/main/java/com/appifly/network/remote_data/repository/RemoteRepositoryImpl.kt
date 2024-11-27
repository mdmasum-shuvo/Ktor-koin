package com.appifly.network.remote_data.repository

import com.appifly.network.data_mapper.toDto
import com.appifly.network.data_object_model.WeatherDto
import com.appifly.network.remote_data.RemoteDataSource
import com.appifly.network.remote_data.model.category.CategoryResponse
import com.appifly.network.remote_data.model.weather.WeatherResponse
import io.ktor.client.call.body
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RemoteRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher
) :
    NetworkDataRepository {
    override suspend fun getAllCategory(lat: Double, lng: Double): Result<WeatherDto> =
        withContext(ioDispatcher) {
            runCatching {
                remoteDataSource.getCategoryDataList(lat, lng).body<WeatherResponse>().toDto()
            }
        }

}