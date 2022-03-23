package com.example.kotlin1hm2ram.ui.fragments.episodes

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.databinding.FragmentEpisodesBinding
import com.example.kotlin1hm2ram.ui.adapters.EpisodesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>(
    R.layout.fragment_episodes) {

    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodesViewModel by viewModels()
    private val episodesAdapter = EpisodesAdapter()


    override fun initialize() {
        binding.recyclerviewEpisodes.adapter = episodesAdapter
    }

    override fun setupObserves() {
        viewModel.fetchEpisodes().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    Log.e("loo", "llo")
                }
                is Resource.Error -> {
                    Log.e("loo", "ol  ${it.message.toString()}")
                }
                is Resource.Success -> {
                    it.data?.let { it1 -> episodesAdapter.setList(it1.result) }
                }
            }
        }
    }
}



