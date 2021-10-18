package com.example.marvelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.models.Hero

class HeroesRecViewAdapter(onHeroClickListener: OnHeroClickListener) : RecyclerView.Adapter<HeroesRecViewAdapter.HeroesViewHolder>() {
    private var heroes = mutableListOf<Hero>()
    private val mOnHeroClickListener = onHeroClickListener

    /**
     * Provides a reference to the type of views being used
     */
    inner class HeroesViewHolder(view: View, onHeroClickListener: OnHeroClickListener) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtName)
        private val localOnHeroClickListener = onHeroClickListener
        init {
            view.setOnClickListener { localOnHeroClickListener.onHeroClick(adapterPosition) }
        }
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.heroes_list_item, parent, false)

        return HeroesViewHolder(view, mOnHeroClickListener)
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

    interface OnHeroClickListener {
        fun onHeroClick(position: Int)
    }
}