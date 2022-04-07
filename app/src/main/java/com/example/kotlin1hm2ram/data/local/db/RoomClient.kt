package com.example.kotlin1hm2ram.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.kotlin1hm2ram.data.local.db.daos.CharacterDao
import com.example.kotlin1hm2ram.data.local.db.daos.EpisodeDao
import com.example.kotlin1hm2ram.data.local.db.daos.LocationDao


class RoomClient {
    fun provideCreateAppDatabase(context: Context) = Room.databaseBuilder(
        context, AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration()
        .build()

    fun provideCharacterDao(cappDatabase: AppDatabase): CharacterDao = cappDatabase.characterDao()

    fun provideEpisodeDao(eappDatabase: AppDatabase): EpisodeDao = eappDatabase.episodeDao()

    fun provideLocationDao(lappDatabase: AppDatabase): LocationDao = lappDatabase.locationDao()
}