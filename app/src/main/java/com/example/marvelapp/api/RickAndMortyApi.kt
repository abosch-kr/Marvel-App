package com.example.marvelapp.api

import com.example.marvelapp.model.GetCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RickAndMortyApi {
    @GET("character/")
    suspend fun getCharacters(
        @QueryMap page: MutableMap<String, String>
    ): GetCharactersResponse
}