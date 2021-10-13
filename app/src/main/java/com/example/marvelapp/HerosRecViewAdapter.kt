package com.example.marvelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class HeroesRecViewAdapter() : RecyclerView.Adapter<HeroesRecViewAdapter.ViewHolder>() {
    private var heroes = mutableListOf<Hero>()

    /**
     * Provides a reference to the type of views being used
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val txtName: TextView = view.findViewById(R.id.txtName)

        override fun onClick(view: View?) {
            val activity = view?.context
            val heroDetailsFragment = HeroDetailsFragment()
            val fragmentTransaction = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame_layout, heroDetailsFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.heroes_list_item, parent, false)

        return ViewHolder(view)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = heroes[position].name
    }

    override fun getItemCount() = heroes.size

    fun setHeroes(updatedHeroes: ArrayList<Hero>) {
        heroes = updatedHeroes
    }
}