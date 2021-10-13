package com.example.marvelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class RecyclerviewFragment : Fragment() {
    private lateinit var heroesRecView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_recyclerview, container, false)
        val heroesAdapter = HeroesRecViewAdapter()
        layoutManager = LinearLayoutManager(context)
        heroesRecView = itemView.findViewById(R.id.heroes_rec_view)
        val heroes = mutableListOf<Hero>()

        heroes.add(Hero("Iron Man", "Tony Stark","Long Island, New York", "Powered armor suit"))
        heroes.add(Hero("Captain America", "Steven Rogers","Brooklyn, New York", "Enhanced strength"))
        heroes.add(Hero("Hulk", "Bruce Banner", "Dayton, Ohio","Superhuman strength"))
        heroes.add(Hero("Black Panther", "T'Challa", "Wakanda, Africa","Vibranium suit"))
        heroes.add(Hero("Deadpool", "Bruce Banner", "Dayton, Ohio","Superhuman strength"))
        heroes.add(Hero("Ant-Man", "Scott Lang", "New York","Size shifting"))
        heroes.add(Hero("Wolverine", "James Howlett", "Canada","Claws"))
        heroes.add(Hero("Vision", "Tom Smith", "Brooklyn, New York","Superhuman intelligence"))
        heroes.add(Hero("Doctor Strange", "Stephen Vincent Strange", "New York","Mastery of magic"))
        heroes.add(Hero("Hawkeye", "Clinton Barton", "Waverly, Iowa","Marksman"))
        heroes.add(Hero("Thor", "Thor Odinson", "Asgard","Hammer"))
        heroes.add(Hero("Anthony", "James Howlett", "Canada","Claws"))
        heroes.add(Hero("Jared", "Tom Smith", "Brooklyn, New York","Superhuman intelligence"))
        heroes.add(Hero("Jim", "Stephen Vincent Strange", "New York","Mastery of magic"))
        heroes.add(Hero("John", "Clinton Barton", "Waverly, Iowa","Marksman"))
        heroes.add(Hero("Mike", "Thor Odinson", "Asgard","Hammer"))

        heroesAdapter.setHeros(heroes as ArrayList<Hero>)
        heroesRecView.apply {
            adapter = heroesAdapter
            layoutManager = LinearLayoutManager(context)
        }
        heroesRecView = itemView.findViewById(R.id.heroes_rec_view)

        return itemView
    }
}