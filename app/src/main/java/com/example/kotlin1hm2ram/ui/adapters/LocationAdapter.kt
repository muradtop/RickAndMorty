package com.example.kotlin1hm2ram.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.databinding.ItemLocationsBinding
import com.example.kotlin1hm2ram.models.RickAndMortyLocations

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private var list: List<RickAndMortyLocations> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<RickAndMortyLocations>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): LocationViewHolder =
        LocationViewHolder(
            ItemLocationsBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    class LocationViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: RickAndMortyLocations) {
            binding.tvLocations.text = model.name
            binding.tvLocationsOne.text = model.type
            binding.tvLocationsTwo.text = model.dimension
        }
    }
}