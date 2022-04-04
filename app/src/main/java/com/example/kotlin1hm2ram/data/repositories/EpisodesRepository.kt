package com.example.kotlin1hm2ram.data.repositories

import com.example.kotlin1hm2ram.base.BaseRepository
import com.example.kotlin1hm2ram.data.local.db.daos.EpisodesDao
import com.example.kotlin1hm2ram.data.remote.apiservices.EpisodesApiService
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val service: EpisodesApiService,
    private val episodesDao: EpisodesDao
) :
    BaseRepository() {

    fun fetchEpisodes(page: Int) = doRequest(
        { service.fetchEpisodes(page) },
        { episodes -> episodesDao.insertAll(* episodes.results.toTypedArray()) })


    fun getEpisodes() = doRequest {
        episodesDao.getAll()
    }
}