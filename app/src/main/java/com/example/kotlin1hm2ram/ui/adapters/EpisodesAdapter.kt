package com.example.kotlin1hm2ram.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.base.BaseDiffUtil
import com.example.kotlin1hm2ram.databinding.ItemEpisodesBinding
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes


class EpisodesAdapter :
    ListAdapter<RickAndMortyEpisodes, EpisodesAdapter.EpisodesViewHolder>(
        BaseDiffUtil()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class EpisodesViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: RickAndMortyEpisodes) {
            binding.tvEpisodes.text = model.name
            binding.tvEpisodesOne.text = model.episode
        }
    }
}