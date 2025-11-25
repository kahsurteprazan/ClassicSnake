package com.example.classicsnake.ui.screens.game.models

import com.example.classicsnake.ui.base.archtectur.UiAction

sealed interface GameAction: UiAction {
    data object CloseScreen : GameAction
    data class ShowDialog(val sessionTime: String, val score: Int) : GameAction
}