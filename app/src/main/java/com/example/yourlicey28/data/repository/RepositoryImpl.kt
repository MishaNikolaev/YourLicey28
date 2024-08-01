package com.example.yourlicey28.data.repository

import com.example.yourlicey28.data.datastore.AppData
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.local.entity.toNews
import com.example.yourlicey28.data.local.entity.toNewsEntity
import com.example.yourlicey28.data.parser.NewParser
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    val appDataStoreManager: AppData,
    val newsParser: NewParser,
    val db: AppDatabase
) : Repository {

    override suspend fun parseNews(): List<News> {
        return newsParser.parse()
    }

    override suspend fun getNews(): Flow<Resource<List<News>>> {
        return flow {
            emit(Resource.Loading())
            val result =
                try {
                    parseNews()
                } catch (ex: Exception) {
                    emit(Resource.Error("Проверьте подключение с интернетом"))
                    null
                }
            val newsEntity = result?.map {
                it.toNewsEntity()
            }
            newsEntity?.let { db.userDao().insertAll(news = it) }
            val newsEntities = db.userDao().getAll()

            val news = newsEntities.map {
                it.toNews()
            }

            emit(Resource.Success(data = news))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun setValue(key: String, value: String) {
        appDataStoreManager.setValue(key, value)
    }

    override suspend fun readValue(key: String): String? {
        return appDataStoreManager.readValue(key)
    }

    override suspend fun addToDb(news: News) {
        db.userDao().insert(news = news.toNewsEntity())
    }

    override suspend fun deleteFromDb(news: News) {
        db.userDao().delete(news = news.toNewsEntity())
    }

    override suspend fun update(news: News) {
        db.userDao().update(news = news.toNewsEntity())
    }

    suspend fun example() {
//        db.userDao()
    }

}