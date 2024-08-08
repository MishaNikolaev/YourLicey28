package com.example.yourlicey28.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yourlicey28.data.local.dao.LinkTextDataDao
import com.example.yourlicey28.data.local.dao.NewsDao
import com.example.yourlicey28.data.local.entity.LinkTextDataEntity
import com.example.yourlicey28.data.local.entity.NewsEntity


@Database(
    entities = [
        NewsEntity::class,
        LinkTextDataEntity::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
    abstract fun linkTextDataDao(): LinkTextDataDao
}