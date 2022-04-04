package com.example.kotlin1hm2ram.data.remote.apiservices


import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): RickAndMortyResponse<RickAndMortyCharacters>

    @GET("api/character/{id}")
    suspend fun fetchSingleCharacter(@Path("id") id: Int): RickAndMortyCharacters
}