package com.example.marvelapp.repository

import com.example.marvelapp.api.RetrofitInstance
import com.example.marvelapp.model.GetCharactersResponse

class Repository {

    suspend fun getCharacters(data: MutableMap<String, String>): GetCharactersResponse {
        return RetrofitInstance.api.getCharacters(data)
    }
}