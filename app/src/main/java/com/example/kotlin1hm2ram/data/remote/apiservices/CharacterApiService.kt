package com.example.kotlin1hm2ram.data.remote.apiservices

import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacters(): RickAndMortyResponse<RickAndMortyCharacters>

    @GET("api/character/{id}")
    suspend fun fetchCharacterId(
        @Path("id") id: Int,
    ): RickAndMortyCharacters
}