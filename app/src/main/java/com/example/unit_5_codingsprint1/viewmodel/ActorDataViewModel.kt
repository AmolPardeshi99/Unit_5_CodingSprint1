package com.example.unit_5_codingsprint1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unit_5_codingsprint1.repository.ActorRepo


class ActorDataViewModel (val repo:ActorRepo): ViewModel() {

    fun addDataToRoomDataBase(){
        repo.addDataListToRoom()
    }

}

//    private val actorRepository= repo
//
//    fun searchActor()=
//        actorRepository.getPagerList()