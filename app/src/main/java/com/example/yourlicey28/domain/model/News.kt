package com.example.yourlicey28.domain.model

data class News(
    val id: Int,
    val text: List<LinkTextData>,
    val photo: String
)
