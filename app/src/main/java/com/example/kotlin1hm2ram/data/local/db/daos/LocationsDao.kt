package com.example.kotlin1hm2ram.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin1hm2ram.models.RickAndMortyLocations

@Dao
interface LocationsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: RickAndMortyLocations)

    @Query("SELECT *FROM rickandmortylocations ")
    suspend fun getAll(): List<RickAndMortyLocations>
}