package com.example.kotlin1hm2ram.ui.fragments.episodes

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
import com.example.kotlin1hm2ram.common.extensions.submitData
import com.example.kotlin1hm2ram.databinding.FragmentEpisodesBinding
import com.example.kotlin1hm2ram.ui.adapters.EpisodesAdapter
import com.example.kotlin1hm2ram.utils.PaginationScrollListener

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>(
    R.layout.fragment_episodes
) {

    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodesViewModel by viewModels()
    private val episodesAdapter = EpisodesAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupObserver() {
        subscribeToEpisodes()
        subscribeToEpisodesLocale()
    }

    private fun setupAdapter() = with(binding.recyclerviewEpisodes) {
        adapter = episodesAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager

        addOnScrollListener(object :
            PaginationScrollListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchEpisodes()
                else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun subscribeToEpisodes() {
        viewModel.episodesState.observe(viewLifecycleOwner) {
            episodesAdapter.submitData(it.results)
        }
    }

    private fun subscribeToEpisodesLocale() {
        viewModel.episodesLocaleState.observe(viewLifecycleOwner) {
            episodesAdapter.submitData(it)
        }
    }

    override fun setupRequest() {
        if (viewModel.episodesState.value == null && isOnline()) viewModel.fetchEpisodes()
        else viewModel.getEpisodes()
    }

    fun isOnline(): Boolean {
        val cm =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}

