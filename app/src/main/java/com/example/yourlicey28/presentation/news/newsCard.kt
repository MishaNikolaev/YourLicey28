package com.example.yourlicey28.presentation.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.yourlicey28.data.parser.LinkText
import com.example.yourlicey28.domain.model.LinkTextData
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.ui.theme.BlueLC
import com.example.yourlicey28.ui.theme.BlueSecondLC
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.LightGreenLC
import com.skydoves.landscapist.glide.GlideImage
@Composable
fun NewsCard(
    news: News,
    onLikeClicked: (news: News) -> Unit,
    onImportantClicked: (news: News) -> Unit,
    isDarkThemeEnabled: Boolean
) {
    val uriHandler = LocalUriHandler.current

    val backgroundColor = if (isDarkThemeEnabled) BlueSecondLC else Color.White
    val textColor = if (isDarkThemeEnabled) Color.White else Color.White

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable { },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(backgroundColor)
        ) {
            GlideImage(
                imageModel = news.photo,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            )

            val shortenedLinkTextData = getShortenedTextData(news.text, 150)

            LinkText(
                linkTextData = shortenedLinkTextData,
                modifier = Modifier.padding(16.dp),
                onClick = { uriHandler.openUri(it) },
                textColor = textColor,
                isDarkThemeEnabled = isDarkThemeEnabled
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = { onLikeClicked.invoke(news) }
                ) {
                    Icon(
                        imageVector = if (news.favourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Like",
                        tint = if (news.favourite) Color.Red else Color.Black
                    )
                }

                IconButton(
                    onClick = { onImportantClicked.invoke(news) }
                ) {
                    Icon(
                        imageVector = if (news.important) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Important",
                        tint = if (news.important) Color.Blue else Color.Black
                    )
                }
            }
        }
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
fun NewsCardInfo(news: News,
                 isDarkThemeEnabled: Boolean) {
    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray

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
            },
            isDarkThemeEnabled = isDarkThemeEnabled,
            textColor = textColor
        )
    }

}