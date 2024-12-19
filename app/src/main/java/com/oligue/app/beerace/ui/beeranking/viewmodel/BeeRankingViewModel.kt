package com.oligue.app.beerace.ui.beeranking.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.viewModelScope
import com.oligue.app.beerace.data.services.exceptions.ErrorException
import com.oligue.app.beerace.data.usecases.GetRaceDurationUseCase
import com.oligue.app.beerace.data.usecases.GetRaceRankListUseCase
import com.oligue.app.beerace.ui.base.BaseViewModel
import com.oligue.app.beerace.ui.base.model.BeeResponseUI
import com.oligue.app.beerace.utils.convertMillisecondsToUI
import com.oligue.app.beerace.utils.convertToMilliseconds
import com.oligue.app.beerace.utils.convertToSeconds
import kotlinx.coroutines.launch

class BeeRankingViewModel(
    private val getRaceDurationUseCase: GetRaceDurationUseCase,
    private val getRaceRankListUseCase: GetRaceRankListUseCase
): BaseViewModel<BeeRankingContract.Event, BeeRankingContract.Success, BeeRankingContract.Effect>() {

    private var countDownTimer: CountDownTimer? = null

    init {
        getRaceDuration()
    }

    override fun setInitialState(): BeeRankingContract.Success {
        return BeeRankingContract.Success(
            timeInSeconds = "00:00",
            beeResponseUI = BeeResponseUI(beeList = emptyList()),
            error = false,
            openWebView = false,
            raceEnds = false
        )
    }

    override fun handleEvents(event: BeeRankingContract.Event) {
        when(event){
            is BeeRankingContract.Event.startRace -> {
                setState {
                    setInitialState()
                }
                getRaceDuration()
            }
        }
    }

    private fun getRaceDuration(){
        viewModelScope.launch {
            getRaceDurationUseCase.getRaceDuration()
                .onSuccess { response ->
                    startCountDownTimer(response.timeInSeconds)
                }
                .onFailure {
                    setState {
                        copy(
                            openWebView = false,
                            error = true
                        )
                    }
                }
        }
    }

    private fun startCountDownTimer(timeInSeconds: Int){
        countDownTimer = object : CountDownTimer(convertToMilliseconds(timeInSeconds), 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val totalSeconds = convertToSeconds(millisUntilFinished)

                if (totalSeconds.toInt() % 2 == 0){
                    getRankingList()
                }

                setState {
                    copy(
                        timeInSeconds = convertMillisecondsToUI(totalSeconds),
                        openWebView = false,
                        error = false
                    )
                }
            }

            override fun onFinish() {
                setState {
                    copy(
                        timeInSeconds = "done",
                        openWebView = false,
                        error = false,
                        raceEnds = true
                    )
                }
            }
        }.start()
    }

    private fun getRankingList(){
        viewModelScope.launch {
            getRaceRankListUseCase.getRankList()
                .onSuccess { response ->
                    setState {
                        copy(
                            beeResponseUI = response,
                            openWebView = false,
                            error = false
                        )
                    }
                }
                .onFailure { error ->
                    if(error is ErrorException){
                        countDownTimer?.cancel()

                        setState {
                            copy(
                                openWebView = true,
                                error = false
                            )
                        }
                    } else {
                        setState {
                            copy(
                                openWebView = false,
                                error = true
                            )
                        }
                    }
                }
        }
    }
}