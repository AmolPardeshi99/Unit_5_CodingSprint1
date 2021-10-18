package com.example.unit_5_codingsprint1.datamodel.remote.responsedto


import com.google.gson.annotations.SerializedName

data class Self(
    @SerializedName("href")
    val href: String?
)