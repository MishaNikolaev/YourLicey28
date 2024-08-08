package com.example.yourlicey28.data.repository

import com.example.yourlicey28.data.datastore.AppData
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.local.entity.LinkTextDataEntity
import com.example.yourlicey28.data.local.entity.NewsEntity
import com.example.yourlicey28.data.local.entity.toEntity
import com.example.yourlicey28.data.local.entity.toNews
import com.example.yourlicey28.data.local.entity.toNewsEntity
import com.example.yourlicey28.data.local.entity.toObject
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

//            val newsEntity = result?.map {
//                it.toNewsEntity()
//            }

            val newsEntity: ArrayList<NewsEntity> = arrayListOf()
            val listLinkTextDataEntity: ArrayList<LinkTextDataEntity> = arrayListOf()

            result?.forEach { news ->

                if (!db.newsDao().existsByPhoto(photo = news.photo)) {
                    newsEntity.add(news.toNewsEntity())
                    news?.text?.forEach { linkText ->
                        listLinkTextDataEntity.add(element = linkText.toEntity())
                    }
                }
            }

//            newsEntity?.let { db.newsDao().insertAll(it) }
            db.newsDao().insertAll(newsEntity)
            db.linkTextDataDao().insertAll(listLinkTextDataEntity)

//            newsEntity?.let { it->
//                db.newsDao().insertAll(news = it)
//                db.linkTextDataDao().insertAll(linkTextData = it.li)
//            }
//            newsEntity?.forEach { it ->
//                db.newsDao().insert(news = it)
//                db.linkTextDataDao().insert(linkTextData = it.)
//            }
//
            val newsEntities = db.newsDao().getAll()

            val newsList: ArrayList<News> = arrayListOf()
            newsEntities.forEach { it ->
                val newsListTextDataEntity = db.linkTextDataDao().getAll(newsId = it.id)
                val new = News(
                    id = it.id,
                    text = newsListTextDataEntity.map { it_1 ->
                        it_1.toObject()
                    },
                    photo = it.photo,
                    favourite = it.favourite
                )
                newsList.add(new)
            }



            emit(Resource.Success(data = newsList))
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
        db.newsDao().insert(news = news.toNewsEntity())
    }

    override suspend fun deleteFromDb(news: News) {
        db.newsDao().delete(news = news.toNewsEntity())
    }

    override suspend fun update(news: News) {
        db.newsDao().update_favourite(favourite = news.favourite,id = news.id)
//        val newsEntities = db.newsDao().getAll()
//        return newsEntities.map {
//            it.toNews()
//        }
    }

    suspend fun example() {
//        db.userDao()
    }

}