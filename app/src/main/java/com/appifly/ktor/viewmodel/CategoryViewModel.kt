package com.appifly.ktor.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appifly.network.remote_data.model.category.CategoryResponse
import com.appifly.network.remote_data.repository.GetAllCategoryApiUseCase
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryUseCase: GetAllCategoryApiUseCase) : ViewModel() {
    private var _categoryList: MutableLiveData<CategoryResponse> = MutableLiveData()

    val categoryList: LiveData<CategoryResponse>
        get() = _categoryList

    init {
        fetchAllCategory()
    }

    fun fetchAllCategory() {
        viewModelScope.launch {
            val categoryUseCase = categoryUseCase()

            categoryUseCase.onSuccess {
                _categoryList.value = it
            }


            Log.e("", "")
        }
    }

}