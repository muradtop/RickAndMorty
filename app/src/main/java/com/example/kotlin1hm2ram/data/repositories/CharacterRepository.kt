package com.example.kotlin1hm2ram.data.repositories

import androidx.lifecycle.liveData
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.data.remote.apiservices.CharacterApiService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val service: CharacterApiService) {

    fun fetchCharacters() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchCharacters()))
        } catch (ioException: Exception) {
            emit(Resource.Error(ioException.localizedMessage, null))
        }
    }

    fun fetchCharacterID(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchCharacterId(id)))
        } catch (ioException: Exception) {
            emit(Resource.Error(ioException.localizedMessage, null))
        }
    }
}