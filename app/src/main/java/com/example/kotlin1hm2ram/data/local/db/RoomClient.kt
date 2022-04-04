package com.example.kotlin1hm2ram.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.kotlin1hm2ram.data.local.db.daos.CharacterDao
import com.example.kotlin1hm2ram.data.local.db.daos.EpisodesDao
import com.example.kotlin1hm2ram.data.local.db.daos.LocationsDao


class RoomClient {

    fun provideCreateAppDatabase(context: Context) = Room.databaseBuilder(
        context, AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration()
        .build()

    fun provideCharacterDao(characterAppDatabase: AppDatabase): CharacterDao =
        characterAppDatabase.characterDao()

    fun provideLocationDao(locationAppDatabase: AppDatabase): LocationsDao =
        locationAppDatabase.LocationsDao()

    fun provideEpisodesDao(episodesAppDatabase: AppDatabase): EpisodesDao =
        episodesAppDatabase.EpisodesDao()
}
