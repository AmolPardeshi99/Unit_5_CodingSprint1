package com.example.unit_5_codingsprint1.datamodel.remote.responsedto


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: Self?
)