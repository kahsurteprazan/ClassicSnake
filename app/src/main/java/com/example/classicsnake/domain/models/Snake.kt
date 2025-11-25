package com.example.classicsnake.domain.models

data class Snake(
    val body: List<Point>,
    val direction: Direction = Direction.NONE
)