package com.example.yourlicey28.domain.model

data class LinkTextData(
    val id:Int,
    val text: String,
    val tag: String? = null,
    val annotation: String? = null,
    val newsId: Int
)
