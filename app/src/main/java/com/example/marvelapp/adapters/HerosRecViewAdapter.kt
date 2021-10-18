package com.example.marvelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.models.Hero

class HeroesRecViewAdapter(private var listItemClickListener: () -> Unit) : RecyclerView.Adapter<HeroesRecViewAdapter.HeroesViewHolder>() {
    private var heroes = mutableListOf<Hero>()

    /**
     * Provides a reference to the type of views being used
     */
    inner class HeroesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtName)
        init {
            view.setOnClickListener { listItemClickListener() }
        }
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.heroes_list_item, parent, false)

        return HeroesViewHolder(view)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.txtName.text = heroes[position].name
    }

    override fun getItemCount() = heroes.size

    fun setHeroes(updatedHeroes: ArrayList<Hero>) {
        heroes = updatedHeroes
    }
}