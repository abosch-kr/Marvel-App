package com.example.marvelapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.marvelapp.R
import com.example.marvelapp.model.Character

class CharactersAdapter(private val glide: RequestManager, onCharacterClickListener: onCharacterClickListener): RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private val characters = mutableListOf<Character>()
    private val mOnCharacterClickListener = onCharacterClickListener

    inner class CharactersViewHolder(view: View, onCharacterClickListener: onCharacterClickListener): RecyclerView.ViewHolder(view) {
        val characterName: TextView = view.findViewById(R.id.character_name)
        val characterImage: ImageView = view.findViewById(R.id.character_image)
        private val localOnCharacterClickListener = onCharacterClickListener
        init {
            view.setOnClickListener { localOnCharacterClickListener.onCharacterClick(characters[bindingAdapterPosition]) }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.heroes_list_item, parent, false)

        return CharactersViewHolder(view, mOnCharacterClickListener)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.characterName.text = characters[position].name
        glide.load(characters[position].image)
            .circleCrop()
            .into(holder.characterImage)
    }

    override fun getItemCount() = characters.size

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacters(updatedCharacters: ArrayList<Character>) {
        characters.clear()
        characters.addAll(updatedCharacters)
        notifyDataSetChanged()
    }

    interface onCharacterClickListener {
        fun onCharacterClick(character: Character)
    }

}
