package com.example.yourlicey28.presentation.news.vm_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.yourlicey28.presentation.news.NewsCard
import com.example.yourlicey28.ui.theme.chooseTheme.ThemeViewModel

@Composable
fun ImportantContent(
    themeViewModel: ThemeViewModel = hiltViewModel(),
    viewmodel: NewsImportantViewModel = hiltViewModel()
) {
    val isDarkThemeEnabled by themeViewModel.isDarkThemeEnabled.collectAsState()

    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray

    if (viewmodel.state.newsList.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            contentPadding = PaddingValues(9.dp)
        ) {
            items(viewmodel.state.newsList.size) { index ->
                Text(text = viewmodel.state.newsList[index].photo)
            }
        }
    }
    else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Важное содержимое",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
    }
}