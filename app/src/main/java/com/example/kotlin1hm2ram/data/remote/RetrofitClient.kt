package com.example.kotlin1hm2ram.data.remote

import com.example.kotlin1hm2ram.common.constants.Constants.BASE_URL
import com.example.kotlin1hm2ram.data.remote.apiservices.CharacterApiService
import com.example.kotlin1hm2ram.data.remote.apiservices.EpisodesApiService
import com.example.kotlin1hm2ram.data.remote.apiservices.LocationsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()


    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun providerCharacterApiService(): CharacterApiService = retrofit.create(CharacterApiService::class.java)

    fun providerEpisodesApiService(): EpisodesApiService = retrofit.create(EpisodesApiService::class.java)

    fun providerLocationsApiService(): LocationsApiService = retrofit.create(LocationsApiService::class.java)

}