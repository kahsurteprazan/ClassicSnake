package com.example.classicsnake.domain.models

sealed interface BonusType {
    data object ExtraLife: BonusType
    data object IncreaseScore: BonusType
}