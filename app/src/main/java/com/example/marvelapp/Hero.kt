package com.example.marvelapp

class Hero (name: String, alterEgo: String, var abilities: ArrayList<String>){
    var name: String = name
    var alterEgo: String = alterEgo
    init {
        abilities = ArrayList()
    }
}