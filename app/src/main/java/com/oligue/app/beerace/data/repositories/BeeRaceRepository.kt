package com.oligue.app.beerace.data.repositories

import com.oligue.app.beerace.data.model.BeeRankResponse
import com.oligue.app.beerace.data.model.RaceDuration
import com.oligue.app.beerace.data.services.exceptions.ErrorException

interface BeeRaceRepository {

    suspend fun getRaceDuration(): Result<RaceDuration>

    @Throws(ErrorException::class)
    suspend fun getRaceRankList(): Result<BeeRankResponse>

}