package com.example.classicsnake.data.local.datastore

import com.example.classicsnake.data.local.datastore.models.GameBoardSize
import com.example.classicsnake.data.local.datastore.models.GameLevel
import com.example.classicsnake.data.local.datastore.models.GameRules
import com.example.classicsnake.data.local.datastore.models.SpawnChanceOfBonusItems
import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val gameLevel: GameLevel = GameLevel.Normal,
    val boardSize: GameBoardSize = GameBoardSize.Medium,
    val spawnChanceOfBonusItems: SpawnChanceOfBonusItems = SpawnChanceOfBonusItems.Normal,
    val gameRules: GameRules = GameRules(),
    val gameResults: Map<GameLevel, List<UserGameResultDto>> = emptyMap()
)