package com.example.yourlicey28.presentation.news.certain_news

import com.example.yourlicey28.domain.model.News

data class NewsStateDetails(
    val newsDetail: News? = News(
        id = 1,
        text = listOf(),
        photo = "",
        favourite = false,
        important = false
    ),
    val isLoading: Boolean = false,
    val error: String? = null
)
