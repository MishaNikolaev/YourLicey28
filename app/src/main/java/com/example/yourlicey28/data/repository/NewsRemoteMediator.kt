package com.example.yourlicey28.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coil.network.HttpException
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.local.entity.NewsEntity
import com.example.yourlicey28.data.local.entity.toNewsEntity
import com.example.yourlicey28.data.parser.NewParser
import java.io.IOException


@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator(
    val db: AppDatabase,
    val newsParser: NewParser,
) : RemoteMediator<Int, NewsEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, NewsEntity>
    ): MediatorResult {
        return try {

            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val news = newsParser.parse()

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.newsDao().clearAll()
                }
                val newsEntities = news.map { it.toNewsEntity() }
                db.newsDao().upsertAll(newsEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = news.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}