package com.example.yourlicey28.data.repository

import com.example.yourlicey28.data.datastore.AppData
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
    val newsParser: NewParser
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
            emit(Resource.Success(data = result))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun setValue(key: String, value: String) {
        appDataStoreManager.setValue(key, value)
    }

    override suspend fun readValue(key: String): String? {
        return appDataStoreManager.readValue(key)
    }

}