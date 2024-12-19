package com.oligue.app.beerace

import com.oligue.app.beerace.data.usecases.GetRaceDurationUseCase
import com.oligue.app.beerace.data.usecases.GetRaceRankListUseCase
import com.oligue.app.beerace.ui.base.model.BeeResponseUI
import com.oligue.app.beerace.ui.base.model.RaceDurationUI
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingContract
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class BeeRankingViewModelTest {

    private lateinit var getRaceDurationUseCase: GetRaceDurationUseCase
    private lateinit var getRaceRankListUseCase: GetRaceRankListUseCase

    @Before
    fun setUp(){
        Dispatchers.setMain(Dispatchers.Unconfined)
        getRaceDurationUseCase = mockk()
        getRaceRankListUseCase = mockk()
    }

    @Test
    fun `when Get Race Duration returs String Time in Seconds`() = runTest {

        // Given
        val cityResponseUI = RaceDurationUI(timeInSeconds = 10)

        val expectedState = BeeRankingContract.Success(
            timeInSeconds = "0 : 10",
            beeResponseUI = BeeResponseUI(beeList = emptyList()),
            error = false,
            openWebView = false,
            raceEnds = false
        )

        coEvery { getRaceDurationUseCase.getRaceDuration() } returns Result.success(cityResponseUI)

        // When
        val viewModel = BeeRankingViewModel(getRaceDurationUseCase, getRaceRankListUseCase)

        // Then
        assertEquals(expectedState, viewModel.viewState.value)
    }

}