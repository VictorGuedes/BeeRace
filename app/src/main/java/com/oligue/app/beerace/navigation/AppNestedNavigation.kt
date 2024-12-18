package com.oligue.app.beerace.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNestedNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreensNavigation.Race.route
    ){
        RankingNestedNavigation(navController)
    }
}

sealed class ScreensNavigation(val route: String){

    //Screens
    object ScreenStartRace: ScreensNavigation(route = "start")
    object ScreenRanking: ScreensNavigation(route = "ranking")

    //Nested Routes
    object Race: ScreensNavigation(route = "race")
}