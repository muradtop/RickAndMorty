package com.example.kotlin1hm2ram.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin1hm2ram.data.local.db.daos.CharacterDao
import com.example.kotlin1hm2ram.data.local.db.daos.EpisodesDao
import com.example.kotlin1hm2ram.data.local.db.daos.LocationsDao
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyLocations

@Database(
    entities = [RickAndMortyCharacters::class, RickAndMortyLocations::class, RickAndMortyEpisodes::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun LocationsDao(): LocationsDao
    abstract fun EpisodesDao(): EpisodesDao
}