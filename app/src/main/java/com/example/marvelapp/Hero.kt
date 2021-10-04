package com.example.marvelapp

data class Hero (
    private val name: String,
    private val alterEgo: String,
    private var abilities: ArrayList<String>
){
    init {
        abilities = ArrayList()
    }
}