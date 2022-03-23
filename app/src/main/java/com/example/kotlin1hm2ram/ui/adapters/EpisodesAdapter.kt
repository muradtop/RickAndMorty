package com.example.kotlin1hm2ram.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.databinding.ItemEpisodesBinding
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes

class EpisodesAdapter : RecyclerView.Adapter<EpisodesAdapter.EpisodesViewHolder>() {

    private var list: List<RickAndMortyEpisodes> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder =
        EpisodesViewHolder(
            ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) =
        holder.onBind(list[position])

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<RickAndMortyEpisodes>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    class EpisodesViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: RickAndMortyEpisodes) {
            binding.tvEpisodes.text = model.name
            binding.tvEpisodesOne.text = model.episode
        }
    }
}