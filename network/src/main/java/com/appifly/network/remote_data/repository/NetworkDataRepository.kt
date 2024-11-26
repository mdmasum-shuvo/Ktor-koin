package com.appifly.network.remote_data.repository

import com.appifly.network.remote_data.model.category.CategoryResponse

interface NetworkDataRepository {

    suspend fun getAllCategory():Result<CategoryResponse>

}