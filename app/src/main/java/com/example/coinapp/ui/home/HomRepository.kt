package com.example.coinapp.ui.home

import com.example.coinapp.base.BaseRepository
import com.example.coinapp.network.ApiFactory
import javax.inject.Inject

class HomRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {

    suspend fun getData(apiKey: String, limit: String) = safeApiRequest {
        apiFactory.getCoinData(apiKey, limit)
    }

}