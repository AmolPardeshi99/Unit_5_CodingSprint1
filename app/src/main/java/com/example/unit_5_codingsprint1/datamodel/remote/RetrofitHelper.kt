package com.example.unit_5_codingsprint1.datamodel.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitHelper {
    private val baseUrl = "https://api.tvmaze.com/"

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService():APIService = getRetrofit().create(APIService::class.java)
}