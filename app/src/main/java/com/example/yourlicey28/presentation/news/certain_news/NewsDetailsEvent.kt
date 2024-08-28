package com.example.yourlicey28.presentation.news.certain_news

sealed class NewsDetailsEvent {
    data class GetNews(val id: Int) : NewsDetailsEvent()
}
