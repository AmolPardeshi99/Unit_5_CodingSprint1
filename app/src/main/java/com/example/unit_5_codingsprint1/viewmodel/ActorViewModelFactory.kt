package com.example.unit_5_codingsprint1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unit_5_codingsprint1.repository.ActorRepo

class ActorViewModelFactory(val repo:ActorRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ActorDataViewModel(repo) as T
    }
}