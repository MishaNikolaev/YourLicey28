package com.example.yourlicey28.presentation.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.yourlicey28.data.parser.LinkText
import com.example.yourlicey28.domain.model.News
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsCard(news: News) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        val uriHandler = LocalUriHandler.current

        GlideImage(
            imageModel = news.photo,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)
                .size(250.dp)
        )

        LinkText(
            linkTextData = news.text,
            modifier = Modifier.padding(top = 5.dp),
            onClick = {
                uriHandler.openUri(it)
            }
        )
    }

}