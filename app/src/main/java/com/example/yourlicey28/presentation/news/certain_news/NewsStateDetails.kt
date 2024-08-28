package com.example.yourlicey28.presentation.news.certain_news

import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.util.Resource
import kotlinx.coroutines.flow.Flow

data class NewsStateDetails(
    val newsDetail: Flow<Resource<News>> = News(
        id = 1,
        text = listOf(),
        photo = "",
        favourite = false,
        important = false
    )
)
