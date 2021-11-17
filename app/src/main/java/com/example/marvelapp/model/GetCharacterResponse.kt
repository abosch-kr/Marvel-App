package com.example.marvelapp.model

data class GetCharactersResponse(
    val info: Info,
    val results: List<Character>
)