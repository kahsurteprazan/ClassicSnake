package com.example.classicsnake.data.local.datastore.models

import kotlinx.serialization.Serializable

@Serializable
enum class SpawnChanceOfBonusItems {
    Low,
    Normal,
    Often
}