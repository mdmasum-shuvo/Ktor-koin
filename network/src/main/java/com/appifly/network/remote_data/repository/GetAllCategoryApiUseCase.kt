package com.appifly.network.remote_data.repository

import com.appifly.network.remote_data.model.category.CategoryResponse

interface GetAllCategoryApiUseCase {
    suspend operator fun invoke(): Result<CategoryResponse>
}


class GetAllCategoryApiUseCaseImpl(private val repository: NetworkDataRepository) :
    GetAllCategoryApiUseCase {

    override suspend fun invoke(): Result<CategoryResponse> {
        return repository.getAllCategory()
    }

}