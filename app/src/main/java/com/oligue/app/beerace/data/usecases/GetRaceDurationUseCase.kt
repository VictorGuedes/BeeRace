package com.oligue.app.beerace.data.usecases

import com.oligue.app.beerace.data.model.RaceDuration
import com.oligue.app.beerace.data.repositories.BeeRaceRepository
import com.oligue.app.beerace.ui.base.model.RaceDurationUI

class GetRaceDurationUseCase (
    private val repository: BeeRaceRepository
) {

    suspend fun getRaceDuration() : Result<RaceDurationUI> {
        return repository.getRaceDuration().map { it.toRaceDurationUI() }
    }
}

fun RaceDuration.toRaceDurationUI() : RaceDurationUI {
    return RaceDurationUI(
        timeInSeconds = timeInSeconds
    )
}