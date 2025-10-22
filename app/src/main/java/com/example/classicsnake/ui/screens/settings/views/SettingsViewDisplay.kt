package com.example.classicsnake.ui.screens.settings.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.classicsnake.ui.screens.settings.models.GameRuleEvent
import com.example.classicsnake.ui.screens.settings.models.SettingsEvent
import com.example.classicsnake.ui.screens.settings.models.SettingsViewState
import com.example.classicsnake.ui.theme.components.JetCheckBox
import com.example.classicsnake.ui.theme.components.JetSection
import com.example.classicsnake.ui.theme.components.JetSwitch
import com.example.classicsnake.ui.theme.components.JetTextButton

@Composable
fun SettingsViewDisplay(
    state: SettingsViewState.Display,
    dispatcher: (SettingsEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
            text = "Настройки"
        )

        JetSection(label = "Уровень сложности") {
            JetSwitch(
                modifier = Modifier.fillMaxWidth(),
                items = listOf("Легко", "Нормально", "Сложно"),
                selectedItemId = state.gameLevel.ordinal
            ) {
                dispatcher.invoke(SettingsEvent.ChangeDifficultyLevel(it))
            }
        }

        JetSection(label = "Шанс появления бонусных предметов") {
            JetSwitch(
                modifier = Modifier.fillMaxWidth(),
                items = listOf("Редко", "Нормально", "Сложно"),
                selectedItemId = state.spawnChanceOfBonusItems.ordinal
            ) {
                dispatcher.invoke(SettingsEvent.ChangeChance(it))
            }
        }

        JetSection(label = "Размер игровой карты") {
            JetSwitch(
                modifier = Modifier.fillMaxWidth(),
                items = listOf("Легко", "Нормально", "Огромная"),
                selectedItemId = state.boardSize.ordinal
            ) {
                dispatcher.invoke(SettingsEvent.ChangeBoardSize(it))
            }
        }

        Text(
            text = "Правила игры",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelSmall
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    2.dp,
                    MaterialTheme.colorScheme.secondaryContainer,
                    RoundedCornerShape(32.dp)
                )
                .background(
                    MaterialTheme.colorScheme.onSecondaryContainer,
                    RoundedCornerShape(32.dp)
                )
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            JetCheckBox(
                checked = state.gameRules.damageColliderEnabled,
                label = "Урон от столкновения со стенами"
            ) {
                dispatcher.invoke(SettingsEvent.ChangeRules(GameRuleEvent.ChangeDamageCollider(it)))
            }
            JetCheckBox(
                checked = state.gameRules.extraLivesEnabled,
                label = "Дополнительные жизни"
            ) {
                dispatcher.invoke(SettingsEvent.ChangeRules(GameRuleEvent.ChangeExtraLives(it)))
            }
            JetCheckBox(
                checked = state.gameRules.throwTailEnabled,
                label = "Отбрасывание хвоста"
            ) {
                dispatcher.invoke(SettingsEvent.ChangeRules(GameRuleEvent.ChangeThrowTail(it)))
            }
            JetCheckBox(
                checked = state.gameRules.randomWallsEnabled,
                label = "Случайные кирпичные стены"
            ) {
                dispatcher.invoke(SettingsEvent.ChangeRules(GameRuleEvent.ChangeRandomWalls(it)))
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        JetTextButton(text = "Вернуться", modifier = Modifier.fillMaxWidth(), onClick = {
            dispatcher.invoke(SettingsEvent.CloseScreen)
        })
    }
}