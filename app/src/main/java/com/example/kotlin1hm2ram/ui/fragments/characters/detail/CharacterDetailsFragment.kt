package com.example.kotlin1hm2ram.ui.fragments.characters.detail


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1hm2ram.R
import com.example.kotlin1hm2ram.base.BaseFragment
import com.example.kotlin1hm2ram.base.BaseViewModel
import com.example.kotlin1hm2ram.common.extensions.setImage
import com.example.kotlin1hm2ram.common.resource.Resource
import com.example.kotlin1hm2ram.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding, BaseViewModel>(
    R.layout.fragment_character_details
) {

    override val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    override val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun setupViews() {
        getData()
    }

    private fun getData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchCharacterId(args.id).collect {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("loo", "olo")
                    }
                    is Resource.Error -> {
                        Log.e("tag", "Error Character ${it.message.toString()}")
                    }
                    is Resource.Success -> {
                        binding.tvtName.text = it.data?.name
                        it.data?.let { it1 -> binding.image.setImage(it1.image) }
                    }
                }
            }
        }
    }
}