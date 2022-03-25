package com.example.kotlin1hm2ram.data.repositories

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.data.remote.apiservices.EpisodesApiService
import com.example.kotlin1hm2ram.data.remote.pagingsources.CharacterPagingSource
import com.example.kotlin1hm2ram.data.remote.pagingsources.EpisodesPagingSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class EpisodesRepositories @Inject constructor(private val service: EpisodesApiService) {

    fun fetchEpisodes() = Pager(PagingConfig(pageSize = 20)) {
        EpisodesPagingSource (service)
    }.flow

}