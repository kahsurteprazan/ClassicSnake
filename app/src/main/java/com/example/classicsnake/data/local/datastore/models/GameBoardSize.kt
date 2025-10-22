package com.example.classicsnake.data.local.datastore.models

import kotlinx.serialization.Serializable

@Serializable
enum class GameBoardSize(val rows: Int, val columns: Int) {
    Small(10, 10),
    Medium(20, 20),
    Huge(30, 30)
}