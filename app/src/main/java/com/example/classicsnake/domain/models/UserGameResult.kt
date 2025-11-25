package com.example.classicsnake.domain.models

import com.example.classicsnake.data.local.datastore.UserGameResultDto

data class UserGameResult(
    val score: Int,
    val time: String
)

fun UserGameResultDto.toDomain() =
    UserGameResult(score, time)

fun UserGameResult.toDto() =
    UserGameResultDto(score, time)