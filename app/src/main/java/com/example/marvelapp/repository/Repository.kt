package com.example.marvelapp.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvelapp.api.RetrofitInstance
import com.example.marvelapp.model.Character
import com.example.marvelapp.api.GetCharactersResponse
import java.lang.Exception

class Repository {

    suspend fun getCharacters(data: Int): GetCharactersResponse {
        return RetrofitInstance.api.getCharacters(data)
    }
}