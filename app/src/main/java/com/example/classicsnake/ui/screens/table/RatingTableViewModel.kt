package com.example.classicsnake.ui.screens.table

import androidx.lifecycle.viewModelScope
import com.example.classicsnake.data.local.datastore.DataStoreManager
import com.example.classicsnake.data.local.datastore.models.GameLevel
import com.example.classicsnake.domain.models.toDomain
import com.example.classicsnake.ui.base.archtectur.BaseViewModel
import com.example.classicsnake.ui.screens.table.models.RatingTableAction
import com.example.classicsnake.ui.screens.table.models.RatingTableEvent
import com.example.classicsnake.ui.screens.table.models.RatingTableViewState
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class RatingTableViewModel(
    private val dataStoreManager: DataStoreManager
) : BaseViewModel<RatingTableEvent, RatingTableViewState, RatingTableAction>(
    initialState = RatingTableViewState.Loading
) {
    override fun obtainEvent(event: RatingTableEvent) {
        when (val state = viewState) {
            is RatingTableViewState.Loading -> reduce(state, event)
            is RatingTableViewState.Display -> reduce(state, event)
        }
    }

    private fun reduce(state: RatingTableViewState.Loading, event: RatingTableEvent) {
        when (event) {
            is RatingTableEvent.EnterScreen -> loadData()
            else -> {

            }
        }
    }

    private fun reduce(state: RatingTableViewState.Display, event: RatingTableEvent) {
        when (event) {
            is RatingTableEvent.ChangeDifficultyLevel -> changeDifficultyLevel(event.number)
            else -> {

            }
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            val settings = dataStoreManager.appSettings.first()
            val results = settings.gameResults.getOrDefault(settings.gameLevel, emptyList())
            viewState = RatingTableViewState.Display(settings.gameLevel, results.map { it.toDomain() })
        }
    }

    private fun changeDifficultyLevel(newValue: Int) {
        viewModelScope.launch {
            val gameLevel = GameLevel.entries[newValue]

            val settings = dataStoreManager.appSettings.first()
            val results = settings.gameResults.getOrDefault(gameLevel, emptyList())
            viewState = RatingTableViewState.Display(gameLevel, results.map { it.toDomain() })
        }
    }
}