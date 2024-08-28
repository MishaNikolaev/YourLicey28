package com.example.yourlicey28.presentation.news.certain_news

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.data.parser.LinkText
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.presentation.news.NewsViewModel
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.chooseTheme.ThemeViewModel
import com.skydoves.landscapist.glide.GlideImage

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Screen(
    /*themeViewModel: ThemeViewModel,
    viewModel: NewsViewModelDetails,
    state: NewsStateDetails,
    processEvent: (NewsDetailsEvent) -> Unit*/
) {

    /*
    val isDarkThemeEnabled by themeViewModel.isDarkThemeEnabled.collectAsState()
    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDarkThemeEnabled) DarkLC else Color.White)
            .padding(16.dp)
    ) {
        GlideImage(
            imageModel = state.newsDetail.photo,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        LinkText(
            linkTextData = state.newsDetail.text,
            textColor = textColor,
            isDarkThemeEnabled = isDarkThemeEnabled
        )
    }

     */
}