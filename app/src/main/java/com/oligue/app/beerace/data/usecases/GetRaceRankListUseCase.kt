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
        beeList = beeList.mapIndexed { index, bee ->
            bee.toBeeUI(index)
        }
    )
}

fun Bee.toBeeUI(index: Int): BeeUI {
    val position = index + 1

    return BeeUI(
        name = name,
        color = color,
        positionString = formatPosition(position),
        position = position
    )
}

fun formatPosition(position: Int): String{
    if (position == 1) return "$position st"
    else if (position in 2..3) return "$position nd"
    else return "$position th"
}