package com.example.yourlicey28.ui.theme.chooseTheme

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.yourlicey28.ui.theme.chooseTheme.TutorialThemeDataStoreConstants.THEME_DATA_STORE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

object TutorialThemeDataStoreConstants {
    const val THEME_DATA_STORE = "THEME_DATA_STORE"
}
class TutorialThemeDataStore @Inject constructor(
    @Named(THEME_DATA_STORE) private val themeDataStore: DataStore<Preferences>
) {
    private object DataStoreKeys {
        const val THEME_KEY = "THEME_KEY"
        val themeKey = booleanPreferencesKey(THEME_KEY)
    }

    private val systemTheme =
        when (Resources.getSystem().configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> { true }
            Configuration.UI_MODE_NIGHT_NO -> { false }
            else -> { false }
        }

    suspend fun enableDarkTheme(enabled: Boolean) {
        themeDataStore.edit { it[DataStoreKeys.themeKey] = enabled }
    }

    val isDarkThemeEnabled: Flow<Boolean> = themeDataStore.data.map {
        it[DataStoreKeys.themeKey] ?: systemTheme
    }
}

