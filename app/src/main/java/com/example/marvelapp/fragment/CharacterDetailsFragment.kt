package com.example.marvelapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.model.Character

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterDetailsFragment(private val character: Character) : Fragment() {
    private lateinit var name: TextView
    private lateinit var origin: TextView
    private lateinit var species: TextView
    private lateinit var status: TextView
    private lateinit var type: TextView
    private lateinit var url: TextView
    private lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        findViews(view)
        setDetails()
    }

    private fun setDetails() {
        name.text = character.name
        origin.text = character.origin.toString()
        species.text = character.species
        status.text = character.status
        type.text = character.type
        url.text = character.url
    }

    private fun findViews(view: View) {
        name = view.findViewById(R.id.txt_character_name)
        origin = view.findViewById(R.id.txt_character_origin)
        species = view.findViewById(R.id.txt_character_species)
        status = view.findViewById(R.id.txt_character_status)
        type = view.findViewById(R.id.txt_character_type)
        url = view.findViewById(R.id.txt_character_url)
        image = view.findViewById(R.id.img_character)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance(characters: Character) = CharacterDetailsFragment(characters)
    }
}