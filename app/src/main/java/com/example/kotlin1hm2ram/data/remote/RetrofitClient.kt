package com.example.kotlin1hm2ram.data.remote

import com.example.kotlin1hm2ram.common.constants.Constants.BASE_URL
import com.example.kotlin1hm2ram.data.remote.apiservices.CharacterApiService
import com.example.kotlin1hm2ram.data.remote.apiservices.EpisodeApiService
import com.example.kotlin1hm2ram.data.remote.apiservices.LocationApiService
 import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharactersApiService(): CharacterApiService =
        retrofit.create(CharacterApiService::class.java)


    fun provideLocationApiService(): LocationApiService =
        retrofit.create(LocationApiService::class.java)

    fun provideEpisodesApiService(): EpisodeApiService =
        retrofit.create(EpisodeApiService::class.java)


}