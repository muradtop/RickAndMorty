package com.example.kotlin1hm2ram.ui.fragments.characters


import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.databinding.FragmentCharactersBinding
import com.example.kotlin1hm2ram.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharactersViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharactersViewModel by activityViewModels()
    private val characterAdapter = CharacterAdapter(this::onItemClickListener)

    override fun initialize() {
        binding.recyclerviewCharacter.adapter = characterAdapter
    }

    override fun setupObserves() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        viewModel.fetchCharacters().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    Log.e("loo", "olo")
                }
                is Resource.Error -> {
                    Log.e("tag", "Error Character ${it.message.toString()}")
                }
                is Resource.Success -> {
                    it.data?.result?.let { it1 -> characterAdapter.setList(it1) }
                }
            }
        }
    }

    private fun onItemClickListener(id: Int) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToDetailFragment(id)
        )
    }
}