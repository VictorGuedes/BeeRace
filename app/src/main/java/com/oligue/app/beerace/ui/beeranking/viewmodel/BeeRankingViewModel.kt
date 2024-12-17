package com.oligue.app.beerace.ui.beeranking.viewmodel

import androidx.lifecycle.viewModelScope
import com.oligue.app.beerace.data.usecases.GetRaceDurationUseCase
import com.oligue.app.beerace.data.usecases.GetRaceRankListUseCase
import com.oligue.app.beerace.ui.base.BaseViewModel
import com.oligue.app.beerace.ui.base.model.BeeResponseUI
import kotlinx.coroutines.launch

class BeeRankingViewModel(
    private val getRaceDurationUseCase: GetRaceDurationUseCase,
    private val getRaceRankListUseCase: GetRaceRankListUseCase
): BaseViewModel<BeeRankingContract.Event, BeeRankingContract.Success, BeeRankingContract.Effect>() {

    init {
        getRaceDuration()
    }

    override fun setInitialState(): BeeRankingContract.Success {
        return BeeRankingContract.Success(
            timeInSeconds = "00:00",
            beeResponseUI = BeeResponseUI(beeList = emptyList()),
            loading = true,
            error = false
        )
    }

    override fun handleEvents(event: BeeRankingContract.Event) {
        when(event){
            is BeeRankingContract.Event.Retry -> {}
        }
    }

    private fun getRaceDuration(){
        viewModelScope.launch {
            getRaceDurationUseCase.getRaceDuration()
                .onSuccess {
                    setState {
                        copy(
                            timeInSeconds = "00:10",
                            beeResponseUI = BeeResponseUI(beeList = emptyList()),
                            loading = false,
                            error = false
                        )
                    }
                }
                .onFailure {
                    setState {
                        copy(loading = false, error = true)
                    }
                }
        }
    }
}