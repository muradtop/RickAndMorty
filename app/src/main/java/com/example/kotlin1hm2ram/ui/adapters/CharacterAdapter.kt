package com.example.kotlin1hm2ram.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.base.BaseDiffModel
import com.example.kotlin1hm2ram.base.BaseDiffUtil
import com.example.kotlin1hm2ram.common.extensions.setImage
import com.example.kotlin1hm2ram.databinding.ItemCharactersBinding
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters


class CharacterAdapter() :
    ListAdapter<RickAndMortyCharacters, CharacterAdapter.CharacterViewHolder>(
        BaseDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class CharacterViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: RickAndMortyCharacters) {
            binding.imageCharacter.setImage(data.image)
            binding.tvName.text = data.name
        }
    }
}