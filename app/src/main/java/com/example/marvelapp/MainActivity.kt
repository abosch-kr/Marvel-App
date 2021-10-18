package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvelapp.fragments.HeroDetailsFragment
import com.example.marvelapp.fragments.RecyclerviewFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Entering onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerviewFragment = RecyclerviewFragment { onHeroClick() }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame_layout, recyclerviewFragment)
        fragmentTransaction.commit()

        Log.d(TAG, "Exiting onCreate")
    }

    private fun onHeroClick() {
        val heroDetailsFragment = HeroDetailsFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame_layout, heroDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        const val TAG = "MainActivity"
    }
}