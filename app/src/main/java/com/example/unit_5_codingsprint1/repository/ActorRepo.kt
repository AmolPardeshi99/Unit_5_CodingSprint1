package com.example.unit_5_codingsprint1.repository


import com.example.unit_5_codingsprint1.datamodel.local.ActorData
import com.example.unit_5_codingsprint1.datamodel.local.ActorDataDAO
import com.example.unit_5_codingsprint1.datamodel.remote.RetrofitHelper
import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTO
import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTOItem
import com.example.unit_5_codingsprint1.ui.pagination.ActorPagingSource
import javax.inject.Inject

class ActorRepo @Inject constructor(val actorDataDAO: ActorDataDAO) {

    private val apiservice = RetrofitHelper.getApiService()

    fun addDataListToRoom(responseDTO: ArrayList<ResponseDTOItem>){
        val responseDataList = ArrayList<ActorData>()
        responseDTO.forEach{
            val newData = ActorData(it.name,it.image?.original,it.country?.name, it.birthday, it.deathday)
            responseDataList.add(newData)
        }
        actorDataDAO.addDataListToRoom(responseDataList)
    }



}