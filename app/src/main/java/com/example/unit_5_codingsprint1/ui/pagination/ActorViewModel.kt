package com.example.unit_5_codingsprint1.ui.pagination

import androidx.lifecycle.ViewModel

class ActorViewModel:ViewModel() {

    private val actorRepository= ActorRepository()

    fun searchActor()=
        actorRepository.getPagerList()

}