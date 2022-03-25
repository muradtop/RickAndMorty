package com.example.kotlin1hm2ram.ui.adapters

 import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.databinding.ItemCharactersBinding
import com.example.kotlin1hm2ram.common.extensions.setImage
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters
 
class CharacterAdapter:
    PagingDataAdapter<RickAndMortyCharacters,CharacterAdapter.CharacterViewHolder>(
        CharactersComparator
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

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

object CharactersComparator: DiffUtil.ItemCallback<RickAndMortyCharacters>(){
        override fun  areItemsTheSame(oldItem: RickAndMortyCharacters, newItem:
        RickAndMortyCharacters): Boolean{
            return oldItem.id == newItem.id
        }

        override fun  areContentsTheSame(oldItem: RickAndMortyCharacters, newItem:
        RickAndMortyCharacters): Boolean{
            return oldItem == newItem
    }
}