package com.example.marvelapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.model.GetCharactersResponse
import com.example.marvelapp.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class SharedViewModel(private val repository: Repository): ViewModel() {
    val mResponse: MutableLiveData<GetCharactersResponse> = MutableLiveData()

    fun getCharacters() {
        viewModelScope.launch {
            val response = repository.getCharacters()
            mResponse.value = response
        }
    }
}