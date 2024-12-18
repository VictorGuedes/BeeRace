package com.oligue.app.beerace.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.oligue.app.beerace.ui.main.StartRaceDestination

fun NavGraphBuilder.RankingNestedNavigation(navController: NavHostController){

    navigation(
        startDestination = ScreensNavigation.ScreenStartRace.route,
        route = ScreensNavigation.Race.route
    ){
        composable(route = ScreensNavigation.ScreenStartRace.route) {
            StartRaceDestination(navController)
        }
    }
}