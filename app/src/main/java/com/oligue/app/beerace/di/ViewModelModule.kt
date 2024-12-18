package com.oligue.app.beerace.di

import com.oligue.app.beerace.data.usecases.GetRaceDurationUseCase
import com.oligue.app.beerace.data.usecases.GetRaceRankListUseCase
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingViewModel
import com.oligue.app.beerace.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel{
        BeeRankingViewModel(
            getRaceDurationUseCase = GetRaceDurationUseCase(repository = get()),
            getRaceRankListUseCase = GetRaceRankListUseCase(repository = get())
        )

        MainViewModel()
    }
}