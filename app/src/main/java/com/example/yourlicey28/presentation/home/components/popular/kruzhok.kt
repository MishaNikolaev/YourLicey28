package com.example.yourlicey28.presentation.home.components.popular

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KruzhokScreen(navController: NavHostController) {
        // Вставьте содержание экрана здесь
        Text("Добро пожаловать на экран 'Кружок'", modifier = Modifier.padding(16.dp))
}