package com.example.marvelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.Hero
import android.util.Log

/**
 * @param onHeroClickListener
 * RecyclerView Adapter class that will translate the Hero data into Views
 */
class HeroesRecViewAdapter(onHeroClickListener: OnHeroClickListener) : RecyclerView.Adapter<HeroesRecViewAdapter.HeroesViewHolder>() {
    private val heroes = mutableListOf<Hero>()
    private val mOnHeroClickListener = onHeroClickListener

    /**
     * @param view
     * @param onHeroClickListener
     * Provides a reference to the type of views being used
     */
    inner class HeroesViewHolder(view: View, onHeroClickListener: OnHeroClickListener) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtName)
        private val localOnHeroClickListener = onHeroClickListener
        init {
            view.setOnClickListener { localOnHeroClickListener.onHeroClick(heroes[bindingAdapterPosition]) }
        }
    }

    /**
     * @param parent
     * @param viewType
     * Creates new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.heroes_list_item, parent, false)

        return HeroesViewHolder(view, mOnHeroClickListener)
    }

    /**
     * @param holder
     * @param position
     * Replaces the contents of a view
     */
    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.txtName.text = heroes[position].name
        Log.d(TAG, holder.txtName.text as String)
    }

    /**
     * @return size of heroes list
     */
    override fun getItemCount() = heroes.size

    /**
     * @param updatedHeroes
     * Updates the mutable list of heroes
     */
    fun setHeroes(updatedHeroes: ArrayList<Hero>) {
        heroes.clear()
        heroes.addAll(updatedHeroes)
        notifyDataSetChanged()
        Log.d(TAG, "heroes list updated")
    }

    interface OnHeroClickListener {
        fun onHeroClick(pHero: Hero)
    }

    companion object {
        const val TAG = "HeroesRecViewAdapter"
    }
}