package com.example.yourlicey28.domain.repository


interface Repository {
    suspend fun setValue(key:String, value: String)

    suspend fun readValue(key: String): String?
}