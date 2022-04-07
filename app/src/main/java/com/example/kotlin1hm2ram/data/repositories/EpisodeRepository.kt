package com.example.kotlin1hm2ram.data.repositories


import com.example.kotlin1hm2ram.base.BaseRepository
import com.example.kotlin1hm2ram.data.local.db.daos.EpisodeDao
import com.example.kotlin1hm2ram.data.remote.apiservices.EpisodeApiService
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val service: EpisodeApiService,
    private val episodeDao: EpisodeDao
) :
    BaseRepository() {

    fun fetchEpisode(page: Int) = doRequest(
        { service.fetchEpisodes(page) },
        { episodes -> episodeDao.insertAllEpisode(* episodes.results.toTypedArray()) })


    fun getEpisodes() = doRequest {
        episodeDao.getAllEpisode()
    }
}