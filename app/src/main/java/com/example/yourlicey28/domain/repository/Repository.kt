package com.example.yourlicey28.domain.repository

import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.util.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {

    suspend fun parseNews():List<News>

    suspend fun getNews(): Flow<Resource<List<News>>>

    suspend fun setValue(key:String,value:String)

    suspend fun readValue(key:String):String?

    suspend fun addToDb(news:News)

    suspend fun deleteFromDb(news:News)

    suspend fun update(news:News)

    suspend fun getImportant(): List<News>
}