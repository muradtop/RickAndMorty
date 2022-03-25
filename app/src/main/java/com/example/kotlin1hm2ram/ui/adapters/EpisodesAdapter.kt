package com.example.kotlin1hm2ram.ui.adapters

 import android.view.LayoutInflater
import android.view.ViewGroup
 import androidx.paging.PagingDataAdapter
 import androidx.recyclerview.widget.DiffUtil
 import androidx.recyclerview.widget.RecyclerView
  import com.example.kotlin1hm2ram.databinding.ItemEpisodesBinding
 import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
 import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes



class EpisodesAdapter :
    PagingDataAdapter<RickAndMortyEpisodes,EpisodesAdapter.EpisodesViewHolder> (
        EpisodesComparator
){


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

object EpisodesComparator: DiffUtil.ItemCallback<RickAndMortyEpisodes>(){
    override fun  areItemsTheSame(oldItem: RickAndMortyEpisodes, newItem:
    RickAndMortyEpisodes
    ): Boolean{
        return oldItem.id == newItem.id
    }

    override fun  areContentsTheSame(oldItem: RickAndMortyEpisodes, newItem:
    RickAndMortyEpisodes
    ): Boolean{
        return oldItem == newItem
    }
}