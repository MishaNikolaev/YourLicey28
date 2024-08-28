package com.example.yourlicey28.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.yourlicey28.data.datastore.AppData
import com.example.yourlicey28.data.datastore.AppDataStoreManager
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.ui.theme.chooseTheme.TutorialThemeDataStoreConstants.THEME_DATA_STORE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDataStoreManager(
        context: Application
    ): AppData {
        return AppDataStoreManager(context)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "database-name.db"
        ).build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object TutorialThemeModule {

    @Singleton
    @Provides
    @Named(THEME_DATA_STORE)
    fun provideThemeDataStore(
        @ApplicationContext context: Context
    ) : DataStore<Preferences> = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile(THEME_DATA_STORE)
    }
}

