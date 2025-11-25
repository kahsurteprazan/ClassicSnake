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
import com.example.classicsnake.data.local.datastore.models.GameBoardSize
import com.example.classicsnake.data.local.datastore.models.GameRules
import com.example.classicsnake.domain.models.BonusItem
import com.example.classicsnake.domain.models.BonusType
import com.example.classicsnake.domain.models.GameLevelConfig
import com.example.classicsnake.domain.models.GameStatus
import com.example.classicsnake.domain.models.Point
import com.example.classicsnake.domain.models.Snake
import com.example.classicsnake.ui.screens.game.models.GameEvent
import com.example.classicsnake.ui.screens.game.models.GameViewState
import com.example.classicsnake.ui.theme.ClassicSnakeTheme

@Composable
fun GameViewDisplay(
    state: GameViewState.Display,
    dispatcher: (GameEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GameTopBar(
            sessionTime = state.sessionTime,
            score = state.score,
            currentSnakeLives = state.currentSnakeLives,
            maxSnakeLives = state.maxSnakeLives,
            modifier = Modifier.fillMaxWidth()
        )

        GameBoard(
            snake = state.snake,
            bonusItems = state.bonusItems,
            blockItems = state.blockItems,
            boardSize = state.boardSize,
            modifier = Modifier.fillMaxWidth()
        )

        GameBottomBar(
            snakeDirection = state.snake.direction,
            modifier = Modifier.fillMaxWidth(),
            dispatcher = dispatcher
        )
    }
}

@Preview
@Composable
private fun ShowPreview() {
    ClassicSnakeTheme {
        GameViewDisplay(
            state = GameViewState.Display(
                snake = Snake(listOf(Point(5,5))),
                currentSnakeLives = 1,
                maxSnakeLives = 4,
                time = 0L,
                score = 0,
                sessionTime = "00:00",
                gameRules = GameRules(),
                gameStatus = GameStatus.Playing,
                gameLevelConfig = GameLevelConfig.Hard,
                bonusItems = listOf(BonusItem(Point(4, 1), BonusType.IncreaseScore)),
                blockItems = listOf(Point(3, 2)),
                boardSize = GameBoardSize.Medium
            )
        ) {

        }
    }
}