package com.example.yourlicey28.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.yourlicey28.domain.model.LinkTextData
import com.example.yourlicey28.domain.model.News

@Entity
data class NewsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val photo: String,
    val favourite:Boolean,
    val important: Boolean
)


@Entity
data class LinkTextDataEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val text: String,
    val tag: String? = null,
    val annotation: String? = null,
    val newsId: Int
)

fun News.toNewsEntity(): NewsEntity {
    return NewsEntity(
        id = id,
        photo = photo,
        favourite = favourite,
        important = important
    )
}

fun NewsEntity.toNews():News {
    return News(
        id = id,
        text = listOf(),
        photo = photo,
        favourite = favourite,
        important = important
    )
}

fun LinkTextData.toEntity():LinkTextDataEntity{
    return LinkTextDataEntity(
        id = id,
        text = text,
        tag = tag,
        annotation =  annotation,
        newsId =  newsId
    )
}

fun LinkTextDataEntity.toObject():LinkTextData{
    return LinkTextData(
        id = id,
        text = text,
        tag = tag,
        annotation =  annotation,
        newsId =  newsId
    )
}