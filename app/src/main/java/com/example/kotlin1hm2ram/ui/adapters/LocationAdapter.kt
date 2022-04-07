package com.example.kotlin1hm2ram.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.base.BaseDiffUtil
import com.example.kotlin1hm2ram.databinding.ItemLocationsBinding
import com.example.kotlin1hm2ram.models.RickAndMortyLocations


class LocationAdapter :
    ListAdapter<RickAndMortyLocations, LocationAdapter.LocationsViewHolder>(BaseDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder =
        LocationsViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }


    class LocationsViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: RickAndMortyLocations) {
            binding.tvLocations.text = model.name
            binding.tvLocationsOne.text = model.type
            binding.tvLocationsTwo.text = model.dimension

        }


    }
}


