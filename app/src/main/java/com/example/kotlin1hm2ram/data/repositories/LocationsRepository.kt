package com.example.kotlin1hm2ram.data.repositories

import com.example.kotlin1hm2ram.base.BaseRepository
import com.example.kotlin1hm2ram.data.local.db.daos.LocationsDao
import com.example.kotlin1hm2ram.data.remote.apiservices.LocationsApiService
import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val service: LocationsApiService,
    private val locationDao: LocationsDao
) :
    BaseRepository() {

    fun fetchLocations(page: Int) = doRequest(
        { service.fetchLocations(page) },
        { location -> locationDao.insertAll(* location.results.toTypedArray()) })


    fun getLocation() = doRequest {
        locationDao.getAll()
    }
}
