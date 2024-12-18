package com.oligue.app.beerace.ui.beeranking

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingContract
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun RankingListScreenDestination(
    navController: NavController
) {
    val viewModel = getViewModel<BeeRankingViewModel>()

    RankingListScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event -> viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is BeeRankingContract.Effect.Navigation.goBack) {

            }
        }
    )
}