package com.example.yourlicey28.data.parser

interface Parser<T> {
    suspend fun parse(): List<T>
}