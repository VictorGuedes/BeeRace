package com.oligue.app.beerace.data.services

import com.oligue.app.beerace.data.model.BeeRankResponse
import com.oligue.app.beerace.data.model.RaceDuration
import retrofit2.http.GET

interface BeeAPI {

    @GET("duration")
    suspend fun getRaceDuration(): RaceDuration

    @GET("status")
    suspend fun getRaceRankList(): BeeRankResponse

}