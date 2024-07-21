package com.example.yourlicey28.data.datastore

interface AppData {

    suspend fun setValue(key:String, value: String)

    suspend fun readValue(key: String): String?
}