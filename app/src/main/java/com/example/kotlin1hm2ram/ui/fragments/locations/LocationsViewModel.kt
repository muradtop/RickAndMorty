package com.example.kotlin1hm2ram.ui.fragments.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin1hm2ram.base.BaseViewModel
import com.example.kotlin1hm2ram.data.repositories.LocationsRepository
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyLocations
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val repository: LocationsRepository,
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false

    private val _locationState = MutableLiveData<RickAndMortyResponse<RickAndMortyLocations>>()
    val locationsState: MutableLiveData<RickAndMortyResponse<RickAndMortyLocations>> =
        _locationState

    private val _locationLocaleState = MutableLiveData<List<RickAndMortyEpisodes>>()
    val locationsLocaleState: LiveData<List<RickAndMortyEpisodes>> = _locationLocaleState

    fun fetchLocations() {
        isLoading = true
        repository.fetchLocations(page).collect(_locationState) {
            page++
            isLoading = false
        }
    }

    fun getLocations() = repository.getLocation().collect(_locationLocaleState, null)

}





