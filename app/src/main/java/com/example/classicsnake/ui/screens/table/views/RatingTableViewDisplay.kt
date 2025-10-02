package com.example.classicsnake.ui.screens.table.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classicsnake.ui.theme.components.JetSection
import com.example.classicsnake.ui.theme.components.JetSwitch
import com.example.classicsnake.ui.theme.components.JetTextButton

@Composable
fun RatingTableViewDisplay(
    /* ... */
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Рейтинговая таблица",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge
        )

        JetSection(
            label = "Уровень сложности",
        ) {
            JetSwitch(
                items = listOf("Легко", "Нормально", "Сложно"),
                selectedItemId = 1
            ) {

            }
        }

        JetSection(label = "Статистика по играм",
            modifier = Modifier.weight(1f)) {
            RatingTableCard(results = emptyList(),
                modifier = Modifier.fillMaxSize())
        }

        Spacer(modifier = Modifier.height(24.dp))

        JetTextButton(text = "Вернуться",
            modifier = Modifier.fillMaxWidth()) {

        }
    }
}

@Preview
@Composable
private fun ShowPreview() {
    RatingTableViewDisplay()
}