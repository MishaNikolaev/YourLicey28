package com.example.yourlicey28.presentation.news

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.WhiteLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto

@ExperimentalFoundationApi
@Composable
fun NewsScreen(viewModel: NewsViewModel, onLikeClicked: (news: News) -> Unit) {
    var selectedTab by remember { mutableStateOf("Новости") }

    println(viewModel.state)
    Column {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .fillMaxWidth()
        ) {
            TabItem(selectedTab, "Новости") { selectedTab = "Новости" }
            Spacer(modifier = Modifier.width(16.dp))
            TabItem(selectedTab, "Важное") { selectedTab = "Важное" }
        }

        if (selectedTab == "Новости") {
            LazyColumn(
                modifier = Modifier.padding(top = 10.dp),
                contentPadding = PaddingValues(9.dp)
            ) {
                items(viewModel.state.news.size) { index ->
                    NewsCard(news = viewModel.state.news[index],
                        onLikeClicked = { it ->
                            onLikeClicked.invoke(it)
                        })
                }
            }
        } else {
            ImportantContent()
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
                CircularProgressIndicator(color = LightBlueLC)
            }
        }
    }
}


@Composable
fun TabItem(selectedTab: String, tabName: String, onClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .height(45.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                color = if (selectedTab == tabName) LightBlueLC else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClicked() }
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = tabName,
            fontSize = 15.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Bold,
            color = if (selectedTab == tabName) DarkLC else Color(0xFF888899)
        )
    }
}

@Composable
fun ImportantContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Важное содержимое",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}