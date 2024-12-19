package com.oligue.app.beerace.ui.main.viewmodel

import com.oligue.app.beerace.ui.base.ViewEvent
import com.oligue.app.beerace.ui.base.ViewSideEffect
import com.oligue.app.beerace.ui.base.ViewState

class MainContract {

    sealed class Event: ViewEvent {
        object goToRankingScreen: Event()
    }

    class Success: ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object goToRankingScren: Navigation()
        }
    }

}