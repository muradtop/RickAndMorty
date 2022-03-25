package com.example.kotlin1hm2ram.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.databinding.ItemLocationsBinding
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyLocations

class LocationAdapter:
    PagingDataAdapter<RickAndMortyLocations, LocationAdapter.LocationViewHolder>(
        LocationsComparator
    ){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }


    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }



   inner class LocationViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: RickAndMortyLocations) {
            binding.tvLocations.text = model.name
            binding.tvLocationsOne.text = model.type
            binding.tvLocationsTwo.text = model.dimension
        }
    }
}

object LocationsComparator: DiffUtil.ItemCallback<RickAndMortyLocations>(){
    override fun  areItemsTheSame(oldItem: RickAndMortyLocations, newItem:
    RickAndMortyLocations
    ): Boolean{
        return oldItem.id == newItem.id
    }

     @SuppressLint("DiffUtilEquals")
     override fun  areContentsTheSame(oldItem: RickAndMortyLocations, newItem:
    RickAndMortyLocations
    ): Boolean{
        return oldItem == newItem
    }
}
