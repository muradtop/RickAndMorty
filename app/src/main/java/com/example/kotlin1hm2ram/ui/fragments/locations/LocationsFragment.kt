package com.example.kotlin1hm2ram.ui.fragments.locations

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
import com.example.kotlin1hm2ram.common.extensions.submitData
import com.example.kotlin1hm2ram.databinding.FragmentLocationsBinding
import com.example.kotlin1hm2ram.models.RickAndMortyLocations
import com.example.kotlin1hm2ram.ui.adapters.LocationAdapter
import com.example.kotlin1hm2ram.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationsViewModel>(
    R.layout.fragment_locations
) {
    override val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationsViewModel by viewModels()
    private val locationAdapter = LocationAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupObserves() {
        subscribeToLocations()
        subscribeToLocationLocale()

    }

    private fun setupAdapter() = with(binding.recyclerviewLocations) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = locationAdapter

        addOnScrollListener(object :
            PaginationScrollListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchLocations() else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun subscribeToLocations() {
        viewModel.locationsState.observe(viewLifecycleOwner) {
            locationAdapter.submitData(it.results)
        }
    }

    private fun subscribeToLocationLocale() {
        viewModel.locationsLocaleState.observe(viewLifecycleOwner) {
            locationAdapter.submitData(it as ArrayList<RickAndMortyLocations>)

        }
    }

    override suspend fun setupRequests() {
        if (viewModel.locationsState.value == null && isOnline()) viewModel.fetchLocations()
        else viewModel.getLocations()
    }

    fun isOnline(): Boolean {
        val cm = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}




