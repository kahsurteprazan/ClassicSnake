package com.example.classicsnake.ui.screens.settings.models

import com.example.classicsnake.data.local.datastore.models.GameBoardSize
import com.example.classicsnake.data.local.datastore.models.GameLevel
import com.example.classicsnake.data.local.datastore.models.GameRules
import com.example.classicsnake.data.local.datastore.models.SpawnChanceOfBonusItems
import com.example.classicsnake.ui.base.archtectur.UiState

sealed interface SettingsViewState: UiState {

    data object Loading: SettingsViewState

    data class Display(
        val gameLevel: GameLevel,
        val boardSize: GameBoardSize,
        val spawnChanceOfBonusItems: SpawnChanceOfBonusItems,
        val gameRules: GameRules
    ) : SettingsViewState
}