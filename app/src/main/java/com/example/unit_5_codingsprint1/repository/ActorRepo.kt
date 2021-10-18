package com.example.unit_5_codingsprint1.repository


import com.example.unit_5_codingsprint1.datamodel.local.ActorData
import com.example.unit_5_codingsprint1.datamodel.local.ActorDataDAO
import com.example.unit_5_codingsprint1.datamodel.remote.RetrofitHelper
import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTOItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ActorRepo (val actorDataDAO: ActorDataDAO) {

    private val apiservice = RetrofitHelper.getApiService()

    fun addDataListToRoom(){
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..328){
                var responseDTO = apiservice.getAllActorsInfo(i)
                val responseDataList = ArrayList<ActorData>()
                responseDTO.forEach{
                    val newData = ActorData(it.name,it.image?.original,it.country?.name, it.birthday, it.deathday)
                    responseDataList.add(newData)
                }
                actorDataDAO.addDataListToRoom(responseDataList)
            }

        }

    }



}