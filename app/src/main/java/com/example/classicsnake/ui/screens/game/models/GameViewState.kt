package com.example.classicsnake.ui.screens.game.models

import com.example.classicsnake.data.local.datastore.models.GameBoardSize
import com.example.classicsnake.data.local.datastore.models.GameRules
import com.example.classicsnake.domain.models.BonusItem
import com.example.classicsnake.domain.models.GameLevelConfig
import com.example.classicsnake.domain.models.GameStatus
import com.example.classicsnake.domain.models.Point
import com.example.classicsnake.domain.models.Snake
import com.example.classicsnake.ui.base.archtectur.UiState

sealed interface GameViewState: UiState {
    data object Loading: GameViewState

    data class Display(
        val snake: Snake,
        val currentSnakeLives: Int,
        val maxSnakeLives: Int,
        val bonusItems: List<BonusItem>,
        val blockItems: List<Point>,
        val boardSize: GameBoardSize,
        val time: Long,
        val sessionTime: String,
        val score: Int,
        val gameStatus: GameStatus,
        val gameLevelConfig: GameLevelConfig,
        val gameRules: GameRules
    ): GameViewState
}