package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelapp.fragments.RecyclerviewFragment
import com.example.marvelapp.fragments.RecyclerviewFragment.Companion.newInstance

class MainActivity : AppCompatActivity() {

    /**
     * @param savedInstanceState
     * Sets the main_frame_layout with a RecyclerView Fragment
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewTransaction()
    }

    /**
     * Instantiates a RecyclerviewFragment, sets the fragmentTransaction to replace main_frame_layout
     * with the recyclerviewFragment
     */
    private fun recyclerViewTransaction() {
        val recyclerviewFragment = newInstance()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame_layout, recyclerviewFragment)
        fragmentTransaction.commit()
    }
}