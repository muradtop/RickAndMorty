package com.example.kotlin1hm2ram.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes


@Dao
interface EpisodesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: RickAndMortyEpisodes)

    @Query("SELECT *FROM rickandmortyepisodes ")
    suspend fun getAll(): List<RickAndMortyEpisodes>
}