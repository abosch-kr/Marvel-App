package com.example.marvelapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.HeroesRecViewAdapter
import com.example.marvelapp.R
import com.example.marvelapp.models.Hero

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class RecyclerviewFragment : Fragment(), HeroesRecViewAdapter.OnHeroClickListener {
    private lateinit var heroesRecView: RecyclerView
    private lateinit var heroes: List<Hero>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val heroesAdapter = HeroesRecViewAdapter(this)
        heroesRecView = view.findViewById(R.id.heroes_rec_view)

        heroes = createHeroes()

        heroesAdapter.setHeroes(heroes as ArrayList<Hero>)
        heroesRecView.apply {
            adapter = heroesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onHeroClick(position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("hero", heroes[position])

        val activity = view?.context
        val heroDetailsFragment = HeroDetailsFragment()
        heroDetailsFragment.arguments = bundle
        val fragmentTransaction = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame_layout, heroDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

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

        return heroes
    }

    companion object {
        const val TAG = "RecyclerviewFragment"
    }
}