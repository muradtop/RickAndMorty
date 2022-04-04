package com.example.kotlin1hm2ram.models

 import androidx.room.Entity
 import androidx.room.PrimaryKey
 import com.example.kotlin1hm2ram.base.BaseDiffModel
 import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyCharacters(
    @PrimaryKey(autoGenerate = false)

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

 ) : BaseDiffModel