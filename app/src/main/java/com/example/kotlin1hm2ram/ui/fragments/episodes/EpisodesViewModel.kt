package com.example.kotlin1hm2ram.ui.fragments.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin1hm2ram.base.BaseViewModel
import com.example.kotlin1hm2ram.data.repositories.EpisodesRepository
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val repository: EpisodesRepository,
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false

    private val _episodesState = MutableLiveData<RickAndMortyResponse<RickAndMortyEpisodes>>()
    val episodesState: LiveData<RickAndMortyResponse<RickAndMortyEpisodes>> = _episodesState

    private val _episodesLocaleState = MutableLiveData<List<RickAndMortyEpisodes>>()
    val episodesLocaleState: LiveData<List<RickAndMortyEpisodes>> = _episodesLocaleState

    fun fetchEpisodes() {
        isLoading = true
        repository.fetchEpisodes(page).collect(_episodesState) {
            page++
            isLoading = false
        }
    }


    fun getEpisodes() = repository.getEpisodes().collect(_episodesLocaleState, null)
}

