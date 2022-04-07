package com.example.kotlin1hm2ram.data.repositories


import com.example.kotlin1hm2ram.base.BaseRepository
import com.example.kotlin1hm2ram.data.local.db.daos.LocationDao
import com.example.kotlin1hm2ram.data.remote.apiservices.LocationApiService
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val service: LocationApiService,
    private val locationDao: LocationDao
    ) :
    BaseRepository() {

    fun fetchLocation(page: Int) = doRequest(
        { service.fetchLocations(page) },
        { location -> locationDao.insertAllLocation(* location.results.toTypedArray()) })


    fun getLocations() = doRequest {
        locationDao.getAllLocation()
    }
}