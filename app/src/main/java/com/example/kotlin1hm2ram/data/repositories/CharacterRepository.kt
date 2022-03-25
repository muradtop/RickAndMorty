package com.example.kotlin1hm2ram.data.repositories

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.data.remote.apiservices.CharacterApiService
import com.example.kotlin1hm2ram.data.remote.pagingsources.CharacterPagingSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val service: CharacterApiService) {

    fun fetchCharacters() = Pager(PagingConfig(pageSize = 20)) {
      CharacterPagingSource(service)
    }.flow



}