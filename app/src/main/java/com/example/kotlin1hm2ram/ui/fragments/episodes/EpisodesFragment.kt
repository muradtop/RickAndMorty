package com.example.kotlin1hm2ram.ui.fragments.episodes

 import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
 import com.example.kotlin1hm2ram.databinding.FragmentEpisodesBinding
import com.example.kotlin1hm2ram.ui.adapters.EpisodesAdapter
 import dagger.hilt.android.AndroidEntryPoint
 import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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
        subscribeToEpisodes()
    }

    private fun subscribeToEpisodes() {
        lifecycleScope.launch {
            viewModel.fetchEpisodes().collectLatest {
                episodesAdapter .submitData(it)
            }
        }
    }

}



