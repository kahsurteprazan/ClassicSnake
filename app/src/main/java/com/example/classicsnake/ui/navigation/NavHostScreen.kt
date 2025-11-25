package com.example.classicsnake.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.classicsnake.ui.screens.game.GameScreen
import com.example.classicsnake.ui.screens.menu.MainMenuScreen
import com.example.classicsnake.ui.screens.settings.SettingsScreen
import com.example.classicsnake.ui.screens.table.RatingTableScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavHostScreen(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavScreen.MainMenu
    ) {
        composable<NavScreen.MainMenu> {
            MainMenuScreen(
                navController
            )
        }

        composable<NavScreen.RatingTable> {
            RatingTableScreen(
                navController
            )
        }

        composable<NavScreen.Settings> {
            SettingsScreen(navController)
        }

        composable<NavScreen.Game> {
            GameScreen(navController)
        }
    }
}