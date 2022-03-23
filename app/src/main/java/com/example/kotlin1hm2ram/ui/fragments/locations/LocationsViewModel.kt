package com.example.kotlin1hm2ram.ui.fragments.locations

import com.example.kotlin1hm2ram.base.BaseViewModel
import com.example.kotlin1hm2ram.data.repositories.LocationsRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val repositor:
    LocationsRepositories,
) : BaseViewModel() {
    fun fetchLocations() = repositor.fetchLocations()
}