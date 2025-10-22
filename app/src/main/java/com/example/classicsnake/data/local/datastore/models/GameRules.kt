package com.example.classicsnake.data.local.datastore.models

import kotlinx.serialization.Serializable

@Serializable
data class GameRules(
    val randomWallsEnabled: Boolean = true,
    val extraLivesEnabled: Boolean = false,
    val throwTailEnabled: Boolean = false,
    val damageColliderEnabled: Boolean = true
)
