package com.example.unit_5_codingsprint1.ui.pagination

import androidx.lifecycle.ViewModel
import com.example.unit_5_codingsprint1.repository.ActorRepo

class ActorViewModel:ViewModel() {

    private val actorRepository= ActorRepository()

    fun searchActor()=
        actorRepository.getPagerList()

}