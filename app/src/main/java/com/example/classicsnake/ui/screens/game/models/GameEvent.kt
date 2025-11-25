package com.example.classicsnake.ui.screens.game.models

import com.example.classicsnake.domain.models.Direction
import com.example.classicsnake.ui.base.archtectur.UiEvent

sealed interface GameEvent: UiEvent {
    data object EnterScreen: GameEvent

    data class ChangeSnakeDirection(val newValue: Direction): GameEvent

    data object CloseScreen: GameEvent
}