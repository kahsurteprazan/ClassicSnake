package com.example.classicsnake.ui.screens.game.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.scale
import com.example.classicsnake.R
import com.example.classicsnake.domain.models.Point
import com.example.classicsnake.domain.models.Snake
import com.example.classicsnake.ui.theme.ClassicSnakeTheme

@Composable
fun GameBoard(
    snake: Snake,
    bonusItems: List<Point>,
    blockItems: List<Point>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val snakeHeadImage = remember {
        context.getDrawable(R.drawable.ic_snake_head)?.toBitmap()?.asImageBitmap()
    }

    val snakeTailImage = remember {
        context.getDrawable(R.drawable.ic_snake_tail)?.toBitmap()?.asImageBitmap()
    }

    val appleImage = remember {
        context.getDrawable(R.drawable.ic_apple)?.toBitmap()?.asImageBitmap()
    }

    val wallImage = remember {
        context.getDrawable(R.drawable.ic_wall)?.toBitmap()?.asImageBitmap()
    }

    BoxWithConstraints(
        modifier
            .border(6.dp, Color(0xFFD7E0D7), RoundedCornerShape(16.dp))
            .padding(6.dp)
    ) {
        Canvas(
            Modifier
                .requiredSize(this.maxWidth - 6.dp, this.maxWidth - 6.dp)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            val fieldWidth = canvasWidth / 10
            val fieldHeight = canvasHeight / 10

            if (appleImage != null) {
                bonusItems.forEach { item ->
                    drawObject(
                        drawScope = this,
                        imageBitmap = appleImage,
                        coordinates = item,
                        width = fieldWidth,
                        height = fieldHeight
                    )
                }
            }

            if (wallImage != null) {
                blockItems.forEach { item ->
                    drawObject(
                        drawScope = this,
                        imageBitmap = wallImage,
                        coordinates = item,
                        width = fieldWidth,
                        height = fieldHeight
                    )
                }
            }

            if (snakeHeadImage != null && snakeTailImage != null) {
                drawSnake(
                    drawScope = this,
                    snake = snake,
                    snakeHead = snakeHeadImage,
                    snakeTail = snakeTailImage,
                    width = fieldWidth,
                    height = fieldHeight
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun ShowPreview() {
    ClassicSnakeTheme {
        GameBoard(
            snake = Snake(listOf(Point(5, 5))),
            bonusItems = listOf(Point(10, 1)),
            blockItems = listOf(Point(10, 5))
        )
    }
}

fun drawSnake(
    drawScope: DrawScope, // на чём рисуем
    snake: Snake, // координаты змейки
    snakeHead: ImageBitmap, // голова змейки
    snakeTail: ImageBitmap, // хвост змейки
    width: Float, // ширина
    height: Float // высота элементов змейки
) {
    snake.body.forEachIndexed { index, point ->
        val image = if (index == 0) {
            snakeHead
        } else {
            snakeTail
        }

        drawObject(
            drawScope = drawScope,
            imageBitmap = image,
            coordinates = point,
            width = width,
            height = height
        )
    }
}

fun drawObject(
    drawScope: DrawScope, // на чём рисуем
    imageBitmap: ImageBitmap, // что рисуем
    coordinates: Point, // где рисуем
    width: Float, // какой ширины
    height: Float // и какой высоты рисуем объект
) {
    val scaledBitmap = imageBitmap.asAndroidBitmap()
        .scale(
            width = width.toInt(),
            height = height.toInt()
        )
        .asImageBitmap()

    drawScope.drawImage(
        image = scaledBitmap,
        topLeft = Offset(
            coordinates.x * width,
            coordinates.y * height
        )
    )
}