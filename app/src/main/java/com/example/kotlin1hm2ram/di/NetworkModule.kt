package com.example.kotlin1hm2ram.di

import com.example.kotlin1hm2ram.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun providerCharacterApiService() = retrofitClient.providerCharacterApiService()

    @Singleton
    @Provides
    fun provideEpisodeApiService() = retrofitClient.providerEpisodesApiService()

    @Singleton
    @Provides
    fun provideLocationsApiService() = retrofitClient.providerLocationsApiService()
}