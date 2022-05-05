package com.example.coinapp.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quote(
    @SerializedName("USD")
    val uSD: USD?
):Parcelable