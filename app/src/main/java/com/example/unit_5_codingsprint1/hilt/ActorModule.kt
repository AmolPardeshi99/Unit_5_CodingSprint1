package com.example.unit_5_codingsprint1.hilt

import com.example.unit_5_codingsprint1.datamodel.remote.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn
object ActorModule {
    private val baseUrl = "https://api.tvmaze.com/"

    @Provides
    fun getRetrofit():APIService{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService::class.java)
    }
}