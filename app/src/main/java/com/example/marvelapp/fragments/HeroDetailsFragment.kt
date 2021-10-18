package com.example.marvelapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.marvelapp.R
import com.example.marvelapp.models.Hero

class HeroDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Get the data being passed in from the RecyclerViewFragment Bundle.
        val hero: Hero? = arguments?.getParcelable("hero")

        Log.d(TAG, hero!!.name)
        Log.d(TAG, hero.alterEgo)
        Log.d(TAG, hero.origin)
        Log.d(TAG, hero.ability)

        val heroName: TextView = view.findViewById(R.id.txt_hero_name)
        val heroAlterEgo: TextView = view.findViewById(R.id.txt_hero_alter_ego)
        val heroOrigin: TextView = view.findViewById(R.id.txt_hero_origin)
        val heroAbility: TextView = view.findViewById(R.id.txt_hero_ability)

        heroName.text = hero.name
        heroAlterEgo.text = hero.alterEgo
        heroOrigin.text = hero.origin
        heroAbility.text = hero.ability
    }

    companion object {
        const val TAG = "HeroDetailsFragment"
    }
}