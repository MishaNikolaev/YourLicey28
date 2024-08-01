package com.example.yourlicey28.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.yourlicey28.data.local.entity.NewsEntity
import com.example.yourlicey28.data.local.entity.UserEntity


@Dao
interface UserDao {
    @Query("SELECT * FROM newsentity") // извлекает все записи из таблицы
    suspend fun getAll(): List<NewsEntity>

    @Query("SELECT * FROM newsentity WHERE id=:id")
    suspend fun getById(id: Int): NewsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Запрос для добавления списка
    suspend fun insertAll(news: List<NewsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Запрос для добавления
    suspend fun insert(news: NewsEntity)

    @Delete
    suspend fun delete(news: NewsEntity)

    @Update
    suspend fun update(news: NewsEntity)
}