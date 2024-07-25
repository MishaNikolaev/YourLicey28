package com.example.yourlicey28.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yourlicey28.data.local.dao.UserDao
import com.example.yourlicey28.data.local.entity.UserEntity


@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}