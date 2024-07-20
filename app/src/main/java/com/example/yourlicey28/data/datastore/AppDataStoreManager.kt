package com.example.yourlicey28.data.datastore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.yourlicey28.util.Devices.APP_DATASTORE
import kotlinx.coroutines.flow.first

class AppDataStoreManager(
    val context:Application
):AppData {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(APP_DATASTORE)

    override suspend fun setValue(key: String, value: String) {
        context.dataStore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }

    override suspend fun readValue(key: String): String? {
        return context.dataStore.data.first()[stringPreferencesKey(key)]
    }
}
