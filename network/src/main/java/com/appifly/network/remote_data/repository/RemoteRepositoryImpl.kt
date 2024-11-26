package com.appifly.network.remote_data.repository

import com.appifly.network.remote_data.RemoteDataSource
import com.appifly.network.remote_data.model.category.CategoryResponse
import io.ktor.client.call.body
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RemoteRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher
) :
    NetworkDataRepository {
    override suspend fun getAllCategory(): Result<CategoryResponse> =
        withContext(ioDispatcher) {
            runCatching {
                remoteDataSource.getCategoryDataList().body<CategoryResponse>()
            }
        }


}