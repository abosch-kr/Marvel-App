package com.example.marvelapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.marvelapp.R
import com.example.marvelapp.model.Hero

/**
 * [Fragment] object that will display the details of a specific Hero inside appropriate Views
 */
class HeroDetailsFragment : Fragment() {
    private lateinit var heroName: TextView
    private lateinit var heroAlterEgo: TextView
    private lateinit var heroOrigin: TextView
    private lateinit var heroAbility: TextView

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * Inflates the layout for this fragment
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_hero_details, container, false)
    }

    /**
     * @param view
     * @param savedInstanceState
     * Retrieves a Hero object from the Bundle and sets the Heroes' details
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hero: Hero? = arguments?.getParcelable(BUNDLE_KEY)

        if (hero != null) {
            Log.d(TAG, hero.name)
            Log.d(TAG, hero.alterEgo)
            Log.d(TAG, hero.origin)
            Log.d(TAG, hero.ability)

            findViews(view)
            setDetails(hero)
        }
    }

    /**
     * @param pView
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
     * @param pHero
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
        const val BUNDLE_KEY = "hero"
        fun newInstance(pHero: Hero) = HeroDetailsFragment().apply {
                arguments = Bundle().also { bundle->
                    bundle.putParcelable(BUNDLE_KEY, pHero)
                }
            }
    }
}