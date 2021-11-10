package com.example.marvelapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.MainViewModelFactory
import com.example.marvelapp.adapter.HeroesRecViewAdapter
import com.example.marvelapp.R
import com.example.marvelapp.SharedViewModel
import com.example.marvelapp.adapter.CharactersAdapter
import com.example.marvelapp.model.Character
import com.example.marvelapp.model.Hero
import com.example.marvelapp.repository.Repository

/**
 * [Fragment] object that will display a RecyclerView
 */
class RecyclerviewFragment : Fragment(), HeroesRecViewAdapter.OnHeroClickListener, CharactersAdapter.OnCharacterClickListener {
    private lateinit var charactersRecView: RecyclerView
    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var viewModel: SharedViewModel

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * Inflates the layout for this fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    /**
     * @param view
     * @param savedInstanceState
     * Instantiates the heroesAdapter, creates heroesRecView and applies adapter and layoutManager, and
     * creates a list of Heroes
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        charactersAdapter = CharactersAdapter(Glide.with(this), this)
        charactersRecView = view.findViewById(R.id.heroes_rec_view)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SharedViewModel::class.java)
        viewModel.getCharacters()
        viewModel.mResponse.observe(viewLifecycleOwner, { response ->
            charactersAdapter.setCharacters(response.results as ArrayList<Character>)
        })

        charactersRecView.apply {
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    /**
     * @param pHero
     * Retrieves data from the Bundle and creates a fragment transaction
     */
    override fun onHeroClick(pHero: Hero) {
        Log.d(TAG, "bundle object successfully retrieved data")

        createTransaction(pHero)
    }

    override fun onCharacterClick(character: Character) {
        createFragmentTransaction(character)
    }

    private fun createFragmentTransaction(character: Character) {
        val activity = view?.context
        val characterDetailsFragment = CharacterDetailsFragment.newInstance(character)
        val fragmentTransaction = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame_layout, characterDetailsFragment)
            .addToBackStack(null)
            .commit()
        Log.d(TAG, "fragment transaction complete")
    }

    /**
     * @param pHero
     * Instantiates a HeroDetailsFragment and sets its arguments to pBundle, sets the fragmentTransaction
     * to replace main_frame_layout with the heroDetailsFragment
     */
    private fun createTransaction(pHero: Hero) {
        val activity = view?.context
        val heroDetailsFragment = HeroDetailsFragment.newInstance(pHero)
        val fragmentTransaction = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame_layout, heroDetailsFragment)
            .addToBackStack(null)
            .commit()
        Log.d(TAG, "fragment transaction complete")
    }

    /**
     * @return a mutable list of Hero objects
     * Creates a mutable list of Hero objects, adds Heroes to the list, and returns the list
     */
    private fun createHeroes(): MutableList<Hero> {
        val heroes = mutableListOf<Hero>()

        heroes.add(Hero("Iron Man", "Tony Stark","Long Island, New York", "Powered armor suit"))
        heroes.add(Hero("Captain America", "Steven Rogers","Brooklyn, New York", "Enhanced strength"))
        heroes.add(Hero("Hulk", "Bruce Banner", "Dayton, Ohio","Superhuman strength"))
        heroes.add(Hero("Black Panther", "T'Challa", "Wakanda, Africa","Vibranium suit"))
        heroes.add(Hero("Deadpool", "Wade Wilson", "New York","Human mutate"))
        heroes.add(Hero("Ant-Man", "Scott Lang", "New York","Size shifting"))
        heroes.add(Hero("Wolverine", "James Howlett", "Canada","Claws"))
        heroes.add(Hero("Vision", "Tom Smith", "Brooklyn, New York","Superhuman intelligence"))
        heroes.add(Hero("Doctor Strange", "Stephen Vincent Strange", "New York","Mastery of magic"))
        heroes.add(Hero("Hawkeye", "Clint Barton", "Waverly, Iowa","Marksman"))
        heroes.add(Hero("Thor", "Thor Odinson", "Asgard","Hammer"))
        heroes.add(Hero("Captain Marvel", "Carol Danvers", "New York","Cosmic energy force powers"))
        heroes.add(Hero("Spider-Man", "Peter Parker", "Brooklyn, New York","Spider senses"))
        heroes.add(Hero("War Machine", "James Rhodes", "New York","Powered armor suit"))
        heroes.add(Hero("Black Widow", "Natasha Romanoff", "Russia","Marksman"))
        heroes.add(Hero("Thanos", "Thanos", "Titan","Infinity stones"))

        Log.d(TAG, "heroes list is set")
        return heroes
    }

    companion object {
        const val TAG = "RecyclerviewFragment"
        fun newInstance() = RecyclerviewFragment()
    }
}