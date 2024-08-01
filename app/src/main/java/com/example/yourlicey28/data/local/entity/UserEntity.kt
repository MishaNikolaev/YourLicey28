package com.example.yourlicey28.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.yourlicey28.domain.model.LinkTextData
import com.example.yourlicey28.domain.model.News

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)

@Entity
data class NewsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
//    val text: List<LinkTextData>,
    val photo: String,
    val favourite:Boolean
)

data class LinkTextData(
    val text: String,
    val tag: String? = null,
    val annotation: String? = null
)

fun News.toNewsEntity(): NewsEntity {
    return NewsEntity(
        id = id,
//        text = text,
        photo = photo,
        favourite = favourite
    )
}

fun NewsEntity.toNews():News {
    return News(
        id = id,
        text = listOf(),
        photo = photo,
        favourite = favourite
    )
}