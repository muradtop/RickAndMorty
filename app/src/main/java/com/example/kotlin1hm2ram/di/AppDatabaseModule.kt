package com.example.kotlin1hm2ram.di

import android.content.Context
import com.example.kotlin1hm2ram.data.local.db.AppDatabase
import com.example.kotlin1hm2ram.data.local.db.RoomClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        RoomClient().provideCreateAppDatabase(context)


    @Singleton
    @Provides
    fun provideCharacterDao(appDatabase: AppDatabase) =
        RoomClient().provideCharacterDao(appDatabase)


    @Singleton
    @Provides
    fun provideEpisodeDao(episodeAppDatabase: AppDatabase) =
        RoomClient().provideEpisodeDao(episodeAppDatabase)

    @Singleton
    @Provides
    fun provideLocationDao(locationAppDatabase: AppDatabase) =
        RoomClient().provideLocationDao(locationAppDatabase)
}