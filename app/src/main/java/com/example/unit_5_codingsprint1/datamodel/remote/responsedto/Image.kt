package com.example.unit_5_codingsprint1.datamodel.remote.responsedto


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("original")
    val original: String?
)