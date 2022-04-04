package com.example.kotlin1hm2ram.common.extensions

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
import com.example.kotlin1hm2ram.models.RickAndMortyEpisodes
import com.example.kotlin1hm2ram.models.RickAndMortyLocations


fun <T, D : RecyclerView.ViewHolder> ListAdapter<T, D>.submitData(data: List<RickAndMortyCharacters>) {
    val dataList =
        ArrayList<T>(currentList)
    dataList.addAll(data)
    submitList(dataList)
}

private fun <E> ArrayList<E>.addAll(elements: ArrayList<RickAndMortyLocations>) {

}
