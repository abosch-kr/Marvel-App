package com.example.marvelapp.models

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
data class Hero (val name: String, val alterEgo: String, val origin: String, val ability: String): Parcelable {
    override fun describeContents(): Int {
        return -1
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(alterEgo)
        dest?.writeString(origin)
        dest?.writeString(ability)
    }

    companion object {
        const val TAG = "Hero"
    }
}