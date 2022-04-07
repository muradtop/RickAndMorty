package com.example.kotlin1hm2ram.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes


@Dao
interface EpisodeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisode(vararg episode: RickAndMortyEpisodes)

    @Query("SELECT * FROM rickandmortyepisodes" )
    suspend fun getAllEpisode() : List<RickAndMortyEpisodes>

}