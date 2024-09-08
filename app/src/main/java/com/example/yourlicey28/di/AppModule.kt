package com.example.yourlicey28.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.yourlicey28.data.datastore.AppData
import com.example.yourlicey28.data.datastore.AppDataStoreManager
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.local.entity.NewsEntity
import com.example.yourlicey28.data.parser.NewParser
import com.example.yourlicey28.data.repository.NewsRemoteMediator
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

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideNewsPager(db: AppDatabase,newsParser: NewParser): Pager<Int, NewsEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = NewsRemoteMediator(
                db = db,
                newsParser = newsParser
            ),
            pagingSourceFactory = {
                db.newsDao().pagingSource()
            }
        )
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

