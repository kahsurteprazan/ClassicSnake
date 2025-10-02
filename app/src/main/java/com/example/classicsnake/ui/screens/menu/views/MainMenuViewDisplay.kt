package com.example.classicsnake.ui.screens.menu.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classicsnake.R
import com.example.classicsnake.ui.components.JetTextButton
import com.example.classicsnake.ui.theme.ClassicSnakeTheme

@Composable
fun MainMenuScreenViewDisplay() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_snake),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.weight(2f))

        JetTextButton(
            text = "Новая игра",
            modifier = Modifier.fillMaxWidth()
        ) {

        }
        JetTextButton(
            text = "Рейтинговая таблица",
            modifier = Modifier.fillMaxWidth()
        ) {

        }
        JetTextButton(
            text = "Настройки",
            modifier = Modifier.fillMaxWidth()
        ) {

        }
    }
}


@Preview
@Composable
private fun ShowPreview() {
    ClassicSnakeTheme {
        MainMenuScreenViewDisplay()

    }
}