package com.example.kotlin1hm2ram.data.repositories

import androidx.lifecycle.liveData
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.data.remote.apiservices.LocationsApiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class LocationsRepositories @Inject constructor(private val service: LocationsApiService) {

    fun fetchLocations() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchLocations()))
        } catch (iException: Exception) {
            emit(Resource.Error(iException.localizedMessage, null))
        }
    }
}