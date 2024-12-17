package com.oligue.app.beerace.data.repositories

import com.oligue.app.beerace.data.model.BeeRankResponse
import com.oligue.app.beerace.data.model.RaceDuration

interface BeeRaceRepository {

    suspend fun getRaceDuration(): Result<RaceDuration>

    suspend fun getRaceRankList(): Result<BeeRankResponse>

}