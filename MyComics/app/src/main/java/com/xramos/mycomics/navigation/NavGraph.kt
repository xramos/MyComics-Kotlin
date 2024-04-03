package com.xramos.mycomics.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xramos.mycomics.ui.screen.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}