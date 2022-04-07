package com.example.kotlin1hm2ram.ui.fragments.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin1hm2ram.base.BaseViewModel
import com.example.kotlin1hm2ram.data.repositories.LocationRepository
import com.example.kotlin1hm2ram.models.RickAndMortyLocations
import com.example.kotlin1hm2ram.models.RickAndMortyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false
    private val _locationsState = MutableLiveData<RickAndMortyResponse<RickAndMortyLocations>>()
    val locationsState: LiveData<RickAndMortyResponse<RickAndMortyLocations>> = _locationsState

    private val _locationsLocaleState = MutableLiveData<List<RickAndMortyLocations>>()
    val episodesLocaleState: LiveData<List<RickAndMortyLocations>> = _locationsLocaleState

    fun fetchLocation() {
        isLoading = true
        repository.fetchLocation(page).collect(_locationsState) {
            page++
            isLoading = false
        }
    }

    fun getLocation() = repository.getLocations().collect(_locationsLocaleState, null)


}