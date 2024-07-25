package com.example.yourlicey28.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.yourlicey28.data.local.entity.UserEntity


@Dao
interface UserDao {
    @Query("SELECT * FROM userentity") // извлекает все записи из таблицы
    suspend fun getAll(): List<UserEntity>

    @Query("SELECT * FROM userentity WHERE id=:id")
    suspend fun getById(id: Int): UserEntity

    @Insert // Запрос для добавления списка
    suspend fun insertAll(users: List<UserEntity>)

    @Insert // Запрос для добавления
    suspend fun insert(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Update
    suspend fun update(user: UserEntity)
}