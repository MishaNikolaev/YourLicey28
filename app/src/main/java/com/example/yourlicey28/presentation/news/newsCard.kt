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
import com.example.yourlicey28.domain.model.LinkTextData
import com.example.yourlicey28.domain.model.News
import com.skydoves.landscapist.glide.GlideImage
@Composable
fun NewsCard(news: News) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        GlideImage(
            imageModel = news.photo,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)
                .size(250.dp)
        )

        val shortenedLinkTextData = getShortenedTextData(news.text, 100)

        LinkText(
            linkTextData = shortenedLinkTextData,
            modifier = Modifier.padding(top = 5.dp),
            onClick = {
                uriHandler.openUri(it)
            }
        )
    }
}

fun getShortenedTextData(textData: List<LinkTextData>, maxLength: Int): List<LinkTextData> {
    val combinedText = textData.joinToString(separator = "") { it.text }
    val shortenedText = if (combinedText.length > maxLength) {
        combinedText.take(maxLength) + "..."
    } else {
        combinedText
    }

    var remainingText = shortenedText
    val newTextData = mutableListOf<LinkTextData>()

    for (linkTextData in textData) {
        if (remainingText.isEmpty()) break

        if (remainingText.length >= linkTextData.text.length) {
            newTextData.add(linkTextData.copy(text = linkTextData.text.take(remainingText.length)))
            remainingText = remainingText.drop(linkTextData.text.length)
        } else {
            newTextData.add(linkTextData.copy(text = remainingText.take(linkTextData.text.length)))
            remainingText = ""
        }
    }

    return newTextData.filter { it.text.isNotBlank() }
}


@Composable
fun NewsCardInfo(news: News) {

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