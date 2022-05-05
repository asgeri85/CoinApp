package com.example.coinapp.network

import com.example.coinapp.model.DataResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiFactory {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCoinData(
        @Header("X-CMC_PRO_API_KEY") apiKey: String, @Query("limit") limit: String,
    ): DataResponse

}