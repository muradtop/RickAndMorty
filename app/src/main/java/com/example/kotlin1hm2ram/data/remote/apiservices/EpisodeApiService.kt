package com.example.kotlin1hm2ram.data.remote.apiservices

import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchEpisodes(@Query("page") page: Int): RickAndMortyResponse<RickAndMortyEpisodes>}
