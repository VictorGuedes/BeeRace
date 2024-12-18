package com.oligue.app.beerace.data.repositories

import com.oligue.app.beerace.data.model.BeeRankResponse
import com.oligue.app.beerace.data.model.RaceDuration
import com.oligue.app.beerace.data.services.BeeAPI
import com.oligue.app.beerace.data.services.exceptions.ErrorException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeeRaceRepositoryImpl(
    private val beeAPI: BeeAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : BeeRaceRepository {

    override suspend fun getRaceDuration(): Result<RaceDuration> = makeApiCall(dispatcher){
        beeAPI.getRaceDuration()
    }

    @Throws(ErrorException::class)
    override suspend fun getRaceRankList(): Result<BeeRankResponse> = makeApiCall(dispatcher){
        beeAPI.getRaceRankList()
    }
}

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}