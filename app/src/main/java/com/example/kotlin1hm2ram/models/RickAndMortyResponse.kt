package com.example.kotlin1hm2ram.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyResponse<T>(
    @PrimaryKey(autoGenerate = false)

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: ArrayList<T>,
)
