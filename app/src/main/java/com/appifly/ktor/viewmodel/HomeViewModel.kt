package com.appifly.ktor.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appifly.network.data_object_model.WeatherDto
import com.appifly.network.remote_data.repository.GetAllCategoryApiUseCase
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

class HomeViewModel(private val categoryUseCase: GetAllCategoryApiUseCase) : ViewModel() {

    private var _categoryList: MutableLiveData<WeatherDto> = MutableLiveData()

    val categoryList: LiveData<WeatherDto>
        get() = _categoryList

    private var _selectedLocation: MutableLiveData<LatLng> = MutableLiveData()

    private val selectedLocation: LiveData<LatLng>
        get() = _selectedLocation

    fun fetchAllCategory(latLng: LatLng) {
        _selectedLocation.value=latLng
        viewModelScope.launch {
            val categoryUseCase = categoryUseCase(selectedLocation.value?.latitude!!, selectedLocation.value?.longitude!!)

            categoryUseCase.onSuccess {
                _categoryList.value = it
            }
            Log.e("", "")
        }
    }



}