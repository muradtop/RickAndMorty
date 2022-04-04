package com.example.kotlin1hm2ram.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.base.BaseDiffUtil
import com.example.kotlin1hm2ram.common.extensions.setImage
import com.example.kotlin1hm2ram.databinding.ItemCharactersBinding
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters

class CharactersAdapter(
) : ListAdapter<RickAndMortyCharacters, CharactersAdapter.CharactersViewHolder>(
    BaseDiffUtil()
) {
    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: RickAndMortyCharacters) {
            binding.imageCharacter.setImage(data.image)
            binding.tvName.text = data.name
        }
    }
}

