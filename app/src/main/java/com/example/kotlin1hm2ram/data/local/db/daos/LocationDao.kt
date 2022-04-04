package com.example.kotlin1hm2ram.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin1hm2ram.models.RickAndMortyLocations

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLocation(vararg locations: RickAndMortyLocations)

    @Query("SELECT *FROM rickandmortylocations ")
    suspend fun getAllLocation(): List<RickAndMortyLocations>
}
