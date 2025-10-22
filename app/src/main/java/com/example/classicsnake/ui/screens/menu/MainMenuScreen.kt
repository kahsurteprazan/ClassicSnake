package com.example.classicsnake.ui.screens.menu

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.classicsnake.ui.screens.menu.views.MainMenuViewDisplay


@Composable
fun MainMenuScreen(navController: NavController) {
    MainMenuViewDisplay{navController.navigate(it)}
}