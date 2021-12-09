package com.example.marvelapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingSource
import com.example.marvelapp.api.GetCharactersResponse
import com.example.marvelapp.model.Character
import com.example.marvelapp.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SharedViewModel(private val repository: Repository): ViewModel() {
    private val _apiResponse: MutableLiveData<GetCharactersResponse> = MutableLiveData()
    val mResponse: LiveData<GetCharactersResponse> = _apiResponse
    private var currentPage = 1

    fun getCharacters() {
        viewModelScope.launch {
            if (currentPage <= _apiResponse.value?.info?.pages ?: 1) {
                Log.i("SharedViewModel", currentPage.toString())
                val response = repository.getCharacters(currentPage)
                currentPage = currentPage.inc()
                val newList = _apiResponse.value?.results?.toMutableList() ?: mutableListOf()
                newList.addAll(response.results)
                val charResponse = GetCharactersResponse(response.info, newList)
                _apiResponse.value = charResponse
            }
        }
    }
}