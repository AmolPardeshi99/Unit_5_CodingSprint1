package com.example.unit_5_codingsprint1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unit_5_codingsprint1.repository.ActorRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ActorViewModel @Inject constructor(val repo:ActorRepo): ViewModel() {


//    private val actorRepository= repo
//
//    fun searchActor()=
//        actorRepository.getPagerList()
}