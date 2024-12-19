package com.oligue.app.beerace.ui.beeranking.viewmodel

import androidx.compose.runtime.Stable
import com.oligue.app.beerace.ui.base.ViewEvent
import com.oligue.app.beerace.ui.base.ViewSideEffect
import com.oligue.app.beerace.ui.base.ViewState
import com.oligue.app.beerace.ui.base.model.BeeResponseUI

class BeeRankingContract {

    sealed class Event: ViewEvent {
        object startRace : Event()
    }

    data class Success(
        val timeInSeconds: String,
        val beeResponseUI: BeeResponseUI,
        val error: Boolean,
        val openWebView: Boolean,
        val raceEnds: Boolean
    ): ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object goBack: Navigation()
        }
    }
}