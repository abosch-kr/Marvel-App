package com.example.marvelapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelapp.repository.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    private val query = "page"
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SharedViewModel(repository, query) as T
    }
}