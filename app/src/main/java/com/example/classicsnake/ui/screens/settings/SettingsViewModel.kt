package com.example.classicsnake.ui.screens.settings

import androidx.lifecycle.viewModelScope
import com.example.classicsnake.data.local.datastore.DataStoreManager
import com.example.classicsnake.data.local.datastore.models.GameBoardSize
import com.example.classicsnake.data.local.datastore.models.GameLevel
import com.example.classicsnake.data.local.datastore.models.SpawnChanceOfBonusItems
import com.example.classicsnake.ui.base.archtectur.BaseViewModel
import com.example.classicsnake.ui.screens.settings.models.GameRuleEvent
import com.example.classicsnake.ui.screens.settings.models.SettingsAction
import com.example.classicsnake.ui.screens.settings.models.SettingsEvent
import com.example.classicsnake.ui.screens.settings.models.SettingsViewState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val dataStoreManager: DataStoreManager
) : BaseViewModel<SettingsEvent, SettingsViewState, SettingsAction>(
    SettingsViewState.Loading
) {
    override fun obtainEvent(event: SettingsEvent) {
        when (val state = viewState) {
            is SettingsViewState.Loading -> reduce(state, event)
            is SettingsViewState.Display -> reduce(state, event)
        }
    }

    private fun reduce(state: SettingsViewState.Loading, event: SettingsEvent) {
        when (event) {
            is SettingsEvent.EnterScreen -> loadData()
            else -> {

            }
        }
    }

    private fun reduce(state: SettingsViewState.Display, event: SettingsEvent) {
        when (event) {
            is SettingsEvent.ChangeChance -> changeChance(event.number)
            is SettingsEvent.ChangeBoardSize -> changeBoardSize(event.number)
            is SettingsEvent.ChangeDifficultyLevel -> changeDifficultyLevel(event.number)
            is SettingsEvent.ChangeRules -> changeRules(state, event.ruleEvent)
            else -> {

            }
        }
    }
    private fun changeChance(newValue: Int) {
        viewModelScope.launch {
            val spawnChanceOfBonusItems = SpawnChanceOfBonusItems.entries[newValue]
            dataStoreManager.saveSpawnChanceOfBonusItems(spawnChanceOfBonusItems )
        }
    }

    private fun changeBoardSize(newValue: Int) {
        viewModelScope.launch {
            val boardSize = GameBoardSize.entries[newValue]
            dataStoreManager.saveGameBoardSize(boardSize)
        }
    }

    private fun changeDifficultyLevel(newValue: Int) {
        viewModelScope.launch {
            val gameLevel = GameLevel.entries[newValue]
            dataStoreManager.saveGameLevel(gameLevel)
        }
    }

    private fun changeRules(state: SettingsViewState.Display, ruleEvent: GameRuleEvent) {
        viewModelScope.launch {
            val gameRules = when(ruleEvent) {
                is GameRuleEvent.ChangeDamageCollider -> {
                    state.gameRules.copy(
                        damageColliderEnabled = ruleEvent.newValue
                    )
                }
                is GameRuleEvent.ChangeThrowTail -> {
                    state.gameRules.copy(
                        throwTailEnabled = ruleEvent.newValue
                    )
                }
                is GameRuleEvent.ChangeExtraLives -> {
                    state.gameRules.copy(
                        extraLivesEnabled = ruleEvent.newValue
                    )
                }
                is GameRuleEvent.ChangeRandomWalls -> {
                    state.gameRules.copy(
                        randomWallsEnabled = ruleEvent.newValue
                    )
                }
            }

            dataStoreManager.saveGameRules(gameRules)
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            dataStoreManager.appSettings.collectLatest { settings ->
                viewState = SettingsViewState.Display(
                    gameLevel = settings.gameLevel,
                    spawnChanceOfBonusItems = settings.spawnChanceOfBonusItems,
                    boardSize = settings.boardSize,
                    gameRules = settings.gameRules
                )
            }
        }
    }
}