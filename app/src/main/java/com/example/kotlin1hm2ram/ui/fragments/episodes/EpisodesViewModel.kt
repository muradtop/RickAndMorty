package com.example.kotlin1hm2ram.ui.fragments.episodes

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kotlin1hm2ram.base.BaseViewModel
import com.example.kotlin1hm2ram.data.repositories.EpisodesRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val repository: EpisodesRepositories,
) : BaseViewModel() {

    fun fetchEpisodes() = repository.fetchEpisodes().cachedIn(viewModelScope)
}