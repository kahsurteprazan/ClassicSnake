package com.example.classicsnake.ui.screens.table.models

import com.example.classicsnake.ui.base.archtectur.UiEvent

sealed interface RatingTableEvent : UiEvent {
    data object EnterScreen : RatingTableEvent
    data object CloseScreen: RatingTableEvent
    data class ChangeDifficultyLevel(val number: Int) : RatingTableEvent
}