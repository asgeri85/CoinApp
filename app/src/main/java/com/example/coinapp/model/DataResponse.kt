package com.example.coinapp.model


import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("status")
    val status: StatusX?
)