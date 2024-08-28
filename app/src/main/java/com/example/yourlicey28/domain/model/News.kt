package com.example.yourlicey28.domain.model

import com.example.yourlicey28.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

data class News(
    val id: Int,
    val text: List<LinkTextData>,
    val photo: String,
    val favourite: Boolean,
    val important: Boolean
) : Flow<Resource<News>> {
    override suspend fun collect(collector: FlowCollector<Resource<News>>) {
        TODO("Not yet implemented")
    }
}
