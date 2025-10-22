package com.example.classicsnake.data.local.datastore.models

import kotlinx.serialization.Serializable

@Serializable
enum class GameLevel {
    Easy,
    Normal,
    Hard
}