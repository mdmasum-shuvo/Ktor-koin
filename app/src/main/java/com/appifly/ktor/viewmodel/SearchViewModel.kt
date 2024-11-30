package com.appifly.ktor.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appifly.network.asset_data.zilla_data.Location

class SearchViewModel : ViewModel() {

    private val _locationList: MutableLiveData<List<Location>> = MutableLiveData(emptyList())

    private val _filteredLocationList: MutableLiveData<List<Location>> = MutableLiveData(emptyList())
    val filteredLocationList: LiveData<List<Location>> get() = _filteredLocationList

    fun setLocationData(list: List<Location>) {
        _locationList.value = list
        _filteredLocationList.value = list // Initialize filtered list
    }

    fun filterLocations(query: String) {
        val currentList = _locationList.value.orEmpty()
        _filteredLocationList.value = if (query.isBlank()) {
            currentList // Show all if query is blank
        } else {
            currentList.filter { it.name!!.contains(query, ignoreCase = true) }
        }
    }
}