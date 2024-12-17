package com.oligue.app.beerace.ui.beeranking.viewmodel

import androidx.compose.runtime.Stable
import com.oligue.app.beerace.ui.base.ViewEvent
import com.oligue.app.beerace.ui.base.ViewSideEffect
import com.oligue.app.beerace.ui.base.ViewState
import com.oligue.app.beerace.ui.base.model.BeeResponseUI

class BeeRankingContract {

    sealed class Event: ViewEvent {
        object Retry : Event()
    }

    @Stable
    data class Success(
        val timeInSeconds: String,
        val beeResponseUI: BeeResponseUI,
        val loading: Boolean,
        val error: Boolean
    ): ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object goBack: Navigation()
        }
    }
}