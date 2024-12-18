package com.oligue.app.beerace.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.oligue.app.beerace.navigation.ScreensNavigation
import com.oligue.app.beerace.ui.main.viewmodel.MainContract
import com.oligue.app.beerace.ui.main.viewmodel.MainViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun StartRaceDestination(navController: NavController) {
    val viewModel = getViewModel<MainViewModel>()

    StarRaceMainScreen(
        effectFlow = viewModel.effect,
        onEventSent = { event -> viewModel.setEvent(event)},
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is MainContract.Effect.Navigation.goToRankingScren) {
                navigateToRanking(navController)
            }
        }
    )
}

private fun navigateToRanking(
    navController: NavController
){
    navController.navigate(route = ScreensNavigation.ScreenRanking.route)
}