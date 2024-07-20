package com.example.yourlicey28.data.repository

import com.example.yourlicey28.data.datastore.AppData
import com.example.yourlicey28.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    val appDataStoreManager : AppData,
) : Repository {
    override suspend fun setValue(key: String, value: String) {
        appDataStoreManager.setValue(key,value)
    }

    override suspend fun readValue(key: String): String? {
        return appDataStoreManager.readValue(key)
    }

}