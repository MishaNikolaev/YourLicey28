package com.example.yourlicey28.presentation.news.vm_components

import com.example.yourlicey28.domain.model.News

data class ImportantState(
    val newsList: List<News> = listOf()
)