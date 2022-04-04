package com.example.kotlin1hm2ram.data.repositories


import com.example.kotlin1hm2ram.base.BaseRepository
import com.example.kotlin1hm2ram.data.local.db.daos.CharacterDao
import com.example.kotlin1hm2ram.data.remote.apiservices.CharacterApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService,
    private val characterDao: CharacterDao
) :
    BaseRepository() {
    fun fetchCharacters(page: Int) = doRequest(
        { service.fetchCharacters(page) },
        { characters ->
            characterDao.insertAll(*characters.results.toTypedArray())
        }
    )

    fun getCharacters() = doRequest {
        characterDao.getAll()
    }
}