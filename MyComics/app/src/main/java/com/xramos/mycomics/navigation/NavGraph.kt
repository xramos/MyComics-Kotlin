package com.xramos.mycomics.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.xramos.mycomics.ui.screen.detail.DetailScreen
import com.xramos.mycomics.ui.screen.home.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            HomeScreen(navigateToCharacter = {
                navController.navigate("${Screen.Detail.route}/${it}")
            })
        }

        composable(route = "${Screen.Detail.route}/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType})
        ) {
            it.arguments?.getInt("characterId")?.let { characterId ->
                DetailScreen(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    characterId = characterId)
            }
        }
    }
}