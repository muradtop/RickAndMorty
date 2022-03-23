package com.example.kotlin1hm2ram.data.remote.apiservices

import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import retrofit2.http.GET

interface EpisodesApiService {
    @GET("api/episode")
    suspend fun fetchEpisodes(): RickAndMortyResponse<RickAndMortyEpisodes>
}
