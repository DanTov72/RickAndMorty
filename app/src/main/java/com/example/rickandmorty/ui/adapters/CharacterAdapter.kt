package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.models.character.CharacterModel

class CharacterAdapter(val list: ArrayList<CharacterModel>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: CharacterModel) {
            binding.imageViewCharacter.load(model.image)
            binding.textViewNameCharacter.text = model.name
            binding.textViewStatus.text = model.status
            binding.textViewSpecies.text = model.species
            binding.textViewType.text = model.type
            binding.textViewFirstSeen.text = model.gender
        }
    }

    fun addNewItems(characterModel: List<CharacterModel>) {
        list.addAll(characterModel)
        notifyDataSetChanged()
    }
}