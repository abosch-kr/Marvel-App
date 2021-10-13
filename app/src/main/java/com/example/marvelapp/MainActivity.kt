package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Entering onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerviewFragment = RecyclerviewFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame_layout, recyclerviewFragment)
        fragmentTransaction.commit()

        Log.d(TAG, "Exiting onCreate")
    }
    companion object {
        const val TAG = "MainActivity"
    }
}