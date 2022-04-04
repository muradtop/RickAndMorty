package com.example.kotlin1hm2ram.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin1hm2ram.data.local.db.daos.CharacterDao
import com.example.kotlin1hm2ram.data.local.db.daos.EpisodeDao
import com.example.kotlin1hm2ram.data.local.db.daos.LocationDao
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyLocations


@Database(entities = [RickAndMortyCharacters::class, RickAndMortyEpisodes::class, RickAndMortyLocations::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun episodeDao(): EpisodeDao

    abstract fun locationDao(): LocationDao


}
