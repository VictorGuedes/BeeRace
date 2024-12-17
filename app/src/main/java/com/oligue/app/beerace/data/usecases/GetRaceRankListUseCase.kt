package com.oligue.app.beerace.data.usecases

import com.oligue.app.beerace.data.model.Bee
import com.oligue.app.beerace.data.model.BeeRankResponse
import com.oligue.app.beerace.data.repositories.BeeRaceRepository
import com.oligue.app.beerace.ui.base.model.BeeResponseUI
import com.oligue.app.beerace.ui.base.model.BeeUI

class GetRaceRankListUseCase(
    private val repository: BeeRaceRepository
) {

    suspend fun getRankList() : Result<BeeResponseUI> {
        return repository.getRaceRankList().map { result ->
            result.toBeeReponseUI()
        }
    }
}

fun BeeRankResponse.toBeeReponseUI() : BeeResponseUI {
    return BeeResponseUI(
        beeList = beeList.map {
            it.toBeeUI()
        }
    )
}

fun Bee.toBeeUI(): BeeUI {
    return BeeUI(
        name = name,
        color = color
    )
}