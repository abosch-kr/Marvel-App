package com.example.marvelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HerosRecViewAdapter(private var heros: ArrayList<Hero>) : RecyclerView.Adapter<HerosRecViewAdapter.ViewHolder>() {

    init {
        heros = ArrayList()
    }

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
        holder.txtName.text = heros[position].name
    }

    override fun getItemCount() = heros.size
}