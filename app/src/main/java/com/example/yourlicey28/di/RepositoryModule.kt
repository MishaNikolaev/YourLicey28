package com.example.yourlicey28.di

import com.example.yourlicey28.data.parser.NewParser
import com.example.yourlicey28.data.parser.Parser
import com.example.yourlicey28.data.repository.RepositoryImpl
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repositoryImpl: RepositoryImpl
    ): Repository


    @Binds
    @Singleton
    abstract fun bindNewsParser(
        newsParser: NewParser
    ): Parser<News>


}