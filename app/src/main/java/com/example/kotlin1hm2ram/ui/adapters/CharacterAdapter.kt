package com.example.kotlin1hm2ram.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hm2ram.databinding.ItemCharactersBinding
import com.example.kotlin1hm2ram.common.extensions.setImage
import com.example.kotlin1hm2ram.models.RickAndMortyCharacters

class CharacterAdapter(val onItemClickListener: (id: Int) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var list: List<RickAndMortyCharacters> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CharacterViewHolder =
        CharacterViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        holder.onBind(list[position])


    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<RickAndMortyCharacters>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                 onItemClickListener(list[absoluteAdapterPosition].id)
            }
        }

        fun onBind(data: RickAndMortyCharacters) {
            binding.imageCharacter.setImage(data.image)
            binding.tvName.text = data.name
//            binding.root.setOnClickListener {
//                onItemClickListener(absoluteAdapterPosition)
//            }
        }
    }
}