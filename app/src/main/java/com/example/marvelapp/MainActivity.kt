package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var herosRecView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        herosRecView = findViewById(R.id.herosRecView)
        val heros: ArrayList<Hero> = ArrayList()
        val adapter: HerosRecViewAdapter = HerosRecViewAdapter()

        heros.add(Hero("Iron Man", "Tony Stark","Long Island, New York", "Powered armor suit"))
        heros.add(Hero("Captain America", "Steven Rogers","Brooklyn, New York", "Enhanced strength"))
        heros.add(Hero("Hulk", "Bruce Banner", "Dayton, Ohio","Superhuman strength"))

        adapter.setHeros(heros)
        herosRecView.adapter = adapter
        herosRecView.layoutManager = LinearLayoutManager(this)
    }
}