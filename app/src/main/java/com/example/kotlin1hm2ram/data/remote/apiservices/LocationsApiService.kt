package com.example.kotlin1hm2ram.data.remote.apiservices

import com.example.kotlin1hm2ram.models.RickAndMortyLocations
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import retrofit2.http.GET

interface LocationsApiService {
    @GET("api/location")
    suspend fun fetchLocations(): RickAndMortyResponse<RickAndMortyLocations>
}