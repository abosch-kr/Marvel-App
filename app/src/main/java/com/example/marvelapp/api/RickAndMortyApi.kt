package com.example.marvelapp.api

import com.example.marvelapp.model.GetCharactersResponse
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): GetCharactersResponse
}