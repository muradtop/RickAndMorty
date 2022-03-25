package com.example.kotlin1hm2ram.ui.fragments.characters


import androidx.fragment.app.activityViewModels
 import androidx.lifecycle.lifecycleScope
 import androidx.recyclerview.widget.LinearLayoutManager
 import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
 import com.example.kotlin1hm2ram.databinding.FragmentCharactersBinding
  import com.example.kotlin1hm2ram.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
  import kotlinx.coroutines.flow.collectLatest
 import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharactersViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharactersViewModel by activityViewModels()
    private val characterAdapter = CharacterAdapter()

    override fun initialize() {
    binding.recyclerviewCharacter.layoutManager = LinearLayoutManager(context)
    binding.recyclerviewCharacter.adapter = characterAdapter


    }

    override fun setupObserves() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        lifecycleScope.launch {
            viewModel.fetchCharacters().collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }
}

