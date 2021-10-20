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

/**
 * Fragment object that will display the details of a specific Hero inside appropriate Views
 */
class HeroDetailsFragment : Fragment() {
    private lateinit var heroName: TextView
    private lateinit var heroAlterEgo: TextView
    private lateinit var heroOrigin: TextView
    private lateinit var heroAbility: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        return inflater.inflate(R.layout.fragment_hero_details, container, false)
    }

    /**
     * Retrieves a Hero object from the Bundle and sets the Heroes' details
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Get the data being passed in from the RecyclerViewFragment Bundle.
        val hero: Hero? = arguments?.getParcelable("hero")

        Log.d(TAG, hero!!.name)
        Log.d(TAG, hero.alterEgo)
        Log.d(TAG, hero.origin)
        Log.d(TAG, hero.ability)

        findViews(view)
        setDetails(hero)
    }

    /**
     * Finds the appropriate Views for each Hero member variable
     */
    private fun findViews(pView: View) {
        heroName = pView.findViewById(R.id.txt_hero_name)
        heroAlterEgo = pView.findViewById(R.id.txt_hero_alter_ego)
        heroOrigin = pView.findViewById(R.id.txt_hero_origin)
        heroAbility = pView.findViewById(R.id.txt_hero_ability)
        Log.d(TAG, "Views have been found")
    }

    /**
     * Sets the text attribute of each Hero detail
     */
    private fun setDetails(pHero: Hero) {
        heroName.text = pHero.name
        heroAlterEgo.text = pHero.alterEgo
        heroOrigin.text = pHero.origin
        heroAbility.text = pHero.ability
        Log.d(TAG, "Hero details are set")
    }

    companion object {
        const val TAG = "HeroDetailsFragment"
    }
}