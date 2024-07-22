package com.example.yourlicey28.presentation.news

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.yourlicey28.ui.theme.roboto

@ExperimentalFoundationApi
@Composable
fun NewsScreen(viewModel: NewsViewModel = hiltViewModel()
) {

    println(viewModel.state)
    Column(
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            contentPadding = PaddingValues(9.dp)
        ) {
            items(viewModel.state.news.size) { index ->
                NewsCard(news = viewModel.state.news[index])
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    thickness = 2.dp
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (viewModel.state.error.isNotBlank()) {
                Text(
                    text = viewModel.state.error,
                    fontFamily = roboto,
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 70.dp)
                )
            }
            if (viewModel.state.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}