package com.example.classicsnake.data.local.datastore

import kotlinx.serialization.Serializable

@Serializable
data class UserGameResultDto(
    val score: Int,
    val time: String
)