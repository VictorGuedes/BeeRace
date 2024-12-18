package com.oligue.app.beerace.ui.main.viewmodel

import com.oligue.app.beerace.ui.base.BaseViewModel

class MainViewModel : BaseViewModel<MainContract.Event, MainContract.Success, MainContract.Effect>() {

    override fun setInitialState(): MainContract.Success {
        return MainContract.Success()
    }

    override fun handleEvents(event: MainContract.Event) {
        when(event){
            is MainContract.Event.goToRankingScreen -> setEffect {
                MainContract.Effect.Navigation.goToRankingScren
            }
        }
    }
}