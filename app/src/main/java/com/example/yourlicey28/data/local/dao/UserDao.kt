package com.example.yourlicey28.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.yourlicey28.data.local.entity.LinkTextDataEntity
import com.example.yourlicey28.data.local.entity.NewsEntity


@Dao
interface NewsDao {
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

    @Query("SELECT EXISTS(SELECT 1 FROM newsentity WHERE photo = :photo)")
    suspend fun existsByPhoto(photo: String): Boolean

    @Update
    suspend fun update(news: NewsEntity)

    @Query("UPDATE newsentity SET favourite = :favourite WHERE id = :id")
    suspend fun update_favourite(favourite:Boolean,id:Int)

    @Query("UPDATE newsentity SET important = :important WHERE id = :id")
    suspend fun update_important(important:Boolean,id:Int)

    @Query("SELECT * FROM newsentity where important = 1")
    suspend fun getImportant():List<NewsEntity>
}

@Dao
interface LinkTextDataDao {
    @Query("SELECT * FROM linktextdataentity WHERE newsId=:newsId") // извлекает все записи из таблицы
    suspend fun getAll(newsId:Int): List<LinkTextDataEntity>

    @Query("SELECT * FROM linktextdataentity WHERE id=:id")
    suspend fun getById(id: Int): LinkTextDataEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Запрос для добавления списка
    suspend fun insertAll(linkTextData: List<LinkTextDataEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Запрос для добавления
    suspend fun insert(linkTextData: LinkTextDataEntity)

    @Delete
    suspend fun delete(linkTextData: LinkTextDataEntity)

    @Update
    suspend fun update(linkTextData: LinkTextDataEntity)
}