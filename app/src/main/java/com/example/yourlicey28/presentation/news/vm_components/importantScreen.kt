package com.example.yourlicey28.presentation.news.vm_components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.yourlicey28.R
import com.example.yourlicey28.data.parser.LinkText
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.presentation.news.NewsCard
import com.example.yourlicey28.presentation.news.getShortenedTextData
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.chooseTheme.ThemeViewModel
import com.example.yourlicey28.ui.theme.monterrat
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImportantContent(
    themeViewModel: ThemeViewModel,
    viewmodel: NewsImportantViewModel,
    onLikeClicked: (news: News) -> Unit,
    onImportantClicked: (news: News) -> Unit,
    onCardClicked: (id: Int) -> Unit,
    isDarkThemeEnabled: Boolean
) {
    val uriHandler = LocalUriHandler.current

    val backgroundColor = if (isDarkThemeEnabled) {
        Color(0xFF2C3E50)
    } else {
        Color.White
    }

    val isDarkThemeEnabled by themeViewModel.isDarkThemeEnabled.collectAsState()

    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray

    if (viewmodel.state.newsList.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            contentPadding = PaddingValues(9.dp)
        ) {
            items(viewmodel.state.newsList.size) { index ->
                NewsCard(
                    news = viewmodel.state.newsList[index],
                    onLikeClicked = onLikeClicked,
                    onImportantClicked = onImportantClicked,
                    onCardClicked = onCardClicked,
                    isDarkThemeEnabled = isDarkThemeEnabled
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.saly_25),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Тут вы можете сохранить важные для вас новости.",
                fontSize = 24.sp,
                fontFamily = monterrat,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = textColor
            )
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

