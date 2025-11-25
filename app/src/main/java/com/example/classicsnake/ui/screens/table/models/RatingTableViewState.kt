package com.example.classicsnake.ui.screens.table.models

import com.example.classicsnake.data.local.datastore.models.GameLevel
import com.example.classicsnake.domain.models.UserGameResult
import com.example.classicsnake.ui.base.archtectur.UiState

sealed interface RatingTableViewState : UiState {
    data object Loading : RatingTableViewState

    data class Display(
        val gameLevel: GameLevel,
        val gameResults: List<UserGameResult>
    ) : RatingTableViewState
}