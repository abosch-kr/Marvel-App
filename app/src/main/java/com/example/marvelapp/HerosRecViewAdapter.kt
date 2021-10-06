package com.example.marvelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeroesRecViewAdapter() : RecyclerView.Adapter<HeroesRecViewAdapter.ViewHolder>() {
    private var heroes = mutableListOf<Hero>()

    /**
     * Provides a reference to the type of views being used
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtName)
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.heros_list_item, parent, false)

        return ViewHolder(view)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = heroes[position].name
    }

    override fun getItemCount() = heroes.size

    fun setHeros(updatedHeroes: ArrayList<Hero>) {
        heroes = updatedHeroes
    }
}