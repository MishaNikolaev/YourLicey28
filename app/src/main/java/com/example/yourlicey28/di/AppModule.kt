package com.example.yourlicey28.di

import android.app.Application
import com.example.yourlicey28.data.datastore.AppData
import com.example.yourlicey28.data.datastore.AppDataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}