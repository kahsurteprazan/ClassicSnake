package com.example.classicsnake.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.compose.rememberNavController
import com.example.classicsnake.ui.navigation.NavHostScreen
import com.example.classicsnake.ui.theme.ClassicSnakeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            ClassicSnakeTheme {
                NavHostScreen(navController)
            }
        }
    }
}