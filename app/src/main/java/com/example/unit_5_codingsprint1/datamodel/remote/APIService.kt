package com.example.unit_5_codingsprint1.datamodel.remote

import com.example.unit_5_codingsprint1.datamodel.remote.responsedto.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("/people")
    suspend fun getAllActorsInfo(@Query("page")page:Int):ResponseDTO
}