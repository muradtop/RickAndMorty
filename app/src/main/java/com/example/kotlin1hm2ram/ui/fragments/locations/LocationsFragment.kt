package com.example.kotlin1hm2ram.ui.fragments.locations

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.databinding.FragmentLocationsBinding
import com.example.kotlin1hm2ram.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationsViewModel>(
    R.layout.fragment_locations) {

    override val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationsViewModel by viewModels()
    private val locationAdapter = LocationAdapter()


    override fun initialize() {
        binding.recyclerviewLocations.adapter = locationAdapter
    }

    override fun setupObserves() {
  subscribeToLocations()
    }


    private fun subscribeToLocations() {
        lifecycleScope.launch {
            viewModel.fetchLocations().collectLatest {
                locationAdapter .submitData(it)
            }
        }
     }
}