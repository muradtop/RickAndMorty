package com.example.kotlin1hm2ram.data.repositories

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.data.remote.apiservices.LocationsApiService
import com.example.kotlin1hm2ram.data.remote.pagingsources.LocationsPagingSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class LocationsRepositories @Inject constructor(private val service: LocationsApiService) {

    fun fetchLocations() = Pager(PagingConfig(pageSize = 20)) {
        LocationsPagingSource(service)
    }.flow

}