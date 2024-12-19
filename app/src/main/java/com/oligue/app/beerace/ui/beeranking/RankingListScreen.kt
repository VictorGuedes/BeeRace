package com.oligue.app.beerace.ui.beeranking

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.oligue.app.beerace.data.repositories.mockBeeList
import com.oligue.app.beerace.ui.base.SIDE_EFFECTS_KEY
import com.oligue.app.beerace.ui.base.model.BeeResponseUI
import com.oligue.app.beerace.ui.base.model.WinnerUI
import com.oligue.app.beerace.ui.beeranking.composables.ErrorUI
import com.oligue.app.beerace.ui.beeranking.composables.RankingUI
import com.oligue.app.beerace.ui.beeranking.composables.TopBar
import com.oligue.app.beerace.ui.beeranking.composables.WinnerUIScreen
import com.oligue.app.beerace.ui.beeranking.composables.openWebView
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingContract
import com.oligue.app.beerace.ui.theme.BeeRaceTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.collect


@Composable
fun RankingListScreen(
    state: BeeRankingContract.Success,
    effectFlow: Flow<BeeRankingContract.Effect>?,
    onEventSent: (event: BeeRankingContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: BeeRankingContract.Effect.Navigation) -> Unit
) {

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is BeeRankingContract.Effect.Navigation.goBack -> {
                    onNavigationRequested(effect)
                }
            }
        }?.collect()
    }

    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        when {
            state.openWebView -> {
                openWebView()
            }

            state.raceEnds -> {
                if (state.beeResponseUI.beeList.isEmpty()){
                    WinnerUIScreen(
                        WinnerUI("No winner","#183da3"),
                        Modifier.padding(paddingValues),
                        onEventSent
                    )
                } else {
                    val winner = state.beeResponseUI.beeList[0]
                    WinnerUIScreen(
                        WinnerUI(winner.name, winner.color),
                        Modifier.padding(paddingValues),
                        onEventSent
                    )
                }
            }

            state.error -> {
                ErrorUI(Modifier.padding(paddingValues), onEventSent)
            }
            else -> {
                RankingUI(
                    timeInSeconds = state.timeInSeconds,
                    beeList = state.beeResponseUI.beeList,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun RankingListScreenPreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            RankingListScreen(
                state = BeeRankingContract.Success(
                    timeInSeconds = "00:00",
                    beeResponseUI = BeeResponseUI(beeList = mockBeeList),
                    openWebView = false,
                    error = false,
                    raceEnds = false
                ),
                effectFlow = null,
                onEventSent = {},
                onNavigationRequested = {},
            )
        }
    }
}