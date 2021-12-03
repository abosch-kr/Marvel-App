package com.example.marvelapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingSource
import com.example.marvelapp.model.GetCharactersResponse
import com.example.marvelapp.repository.Repository
import kotlinx.coroutines.launch

class SharedViewModel(private val repository: Repository, private val query: String): ViewModel() {
    val mResponse: MutableLiveData<GetCharactersResponse> = MutableLiveData()

    fun getCharacters() {
        viewModelScope.launch {
            val data: MutableMap<String, String> = HashMap()
            data[query] = 3.toString()
            val response = repository.getCharacters(data = data)
            mResponse.value = response
        }
    }
}