package com.example.yourlicey28.presentation.news

import com.example.yourlicey28.domain.model.News

data class NewsState(
//    val news: List<News> = listOf(),
    val isLoading: Boolean = false,
    val error: String = ""
)