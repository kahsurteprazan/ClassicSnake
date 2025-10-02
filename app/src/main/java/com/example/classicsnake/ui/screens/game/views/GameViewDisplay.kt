package com.example.classicsnake.ui.screens.game.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classicsnake.domain.models.Point
import com.example.classicsnake.domain.models.Snake
import com.example.classicsnake.ui.theme.ClassicSnakeTheme

@Composable
fun GameViewDisplay() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GameTopBar(
            sessionTime = "00:00",
            score = 0,
            currentSnakeLives = 1,
            maxSnakeLives = 4,
            modifier = Modifier.fillMaxWidth()
        )

        GameBoard(
            snake = Snake(listOf(Point(5, 5))),
            bonusItems = listOf(Point(4, 2)),
            blockItems = listOf(Point(3, 5))
        )

        GameBottomBar()
    }
}

@Preview
@Composable
private fun ShowPreview() {
    ClassicSnakeTheme {
        GameViewDisplay()
    }
}