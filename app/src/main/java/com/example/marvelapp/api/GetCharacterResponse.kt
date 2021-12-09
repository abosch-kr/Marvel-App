package com.example.marvelapp.api

import com.example.marvelapp.model.Character
import com.example.marvelapp.model.Info

data class GetCharactersResponse(
    val info: Info,
    val results: List<Character>
)