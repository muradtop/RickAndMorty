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
import com.example.kotlin1hm2ram.ui.adapters.LocationAdapter
import com.example.kotlin1hm2ram.utils.PaginationScrollListener

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationsBinding , LocationViewModel>(
    R.layout.fragment_locations
) {
    override val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter()

    override fun setupObserver() {
        subscribeToLocations()
        subscribeToLocationLocale()
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recyclerviewLocations) {
        adapter = locationAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager

        addOnScrollListener(object :
            PaginationScrollListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchLocation()
                else null
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
        viewModel.episodesLocaleState.observe(viewLifecycleOwner) {
            locationAdapter.submitData(it)
        }
    }

    override fun setupRequest() {
        if (viewModel.locationsState.value == null && isOnline()) viewModel.fetchLocation()
        else viewModel.getLocation()
    }

    fun isOnline(): Boolean {
        val cm =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}