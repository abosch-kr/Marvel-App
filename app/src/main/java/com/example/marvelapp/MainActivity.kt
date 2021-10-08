package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var heroesRecView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Entering onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroesRecView = findViewById(R.id.heroes_rec_view)
        val heroes = mutableListOf<Hero>()
        val heroesAdapter = HeroesRecViewAdapter()

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
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        Log.d(TAG, "Exiting onCreate")
    }
    companion object {
        const val TAG = "MainActivity"
    }
}