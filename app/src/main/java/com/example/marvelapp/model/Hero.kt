package com.example.marvelapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero (val name: String, val alterEgo: String, val origin: String, val ability: String): Parcelable {
    companion object {
        const val TAG = "Hero"
    }
}