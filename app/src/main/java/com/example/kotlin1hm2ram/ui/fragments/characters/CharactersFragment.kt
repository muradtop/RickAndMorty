package com.example.kotlin1hm2ram.ui.fragments.characters


import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
import com.example.kotlin1hm2ram.common.extensions.submitData
import com.example.kotlin1hm2ram.utils.PaginationScrollListener
import com.example.kotlin1hm2ram.databinding.FragmentCharactersBinding
import com.example.kotlin1hm2ram.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharactersViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharactersViewModel by viewModels()
    private val characterAdapter = CharacterAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupObserves() {
        subscribeToCharacters()
        subscribeToCharactersLocale()

    }

    private fun setupAdapter() = with(binding.recyclerviewCharacter) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = characterAdapter

        addOnScrollListener(object :
            PaginationScrollListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchCharacter() else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun subscribeToCharacters() {
        viewModel.characterState.observe(viewLifecycleOwner) {
            characterAdapter.submitData(it.results)
        }
    }

    private fun subscribeToCharactersLocale() {
        viewModel.characterLocaleState.observe(viewLifecycleOwner) {
            characterAdapter.submitData(it)

        }
    }

    override suspend fun setupRequests() {
        if (viewModel.characterState.value == null && isOnline()) viewModel.fetchCharacter()
        else viewModel.getCharacters()
    }

    fun isOnline(): Boolean {
        val cm = requireActivity().getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}