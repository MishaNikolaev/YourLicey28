package com.example.yourlicey28.presentation.news.certain_news

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State

private const val TAG = "NewsViewModelDetail"

@HiltViewModel
class NewsViewModelDetails @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(NewsStateDetails())
    val state: State<NewsStateDetails> = _state

    init{
        val id = savedStateHandle.get<Int>("id")
        processEvent(event = NewsDetailsEvent.GetNews(id = id!!))
    }
    fun processEvent(event: NewsDetailsEvent) {
        when (event) {
            is NewsDetailsEvent.GetNews -> getNews(id = event.id)
        }
    }


    private fun getNews(id: Int) {
        viewModelScope.launch {
            val newsDetail = repository.getNews(id = id)
            _state.value = _state.value.copy(newsDetail = newsDetail)
        }
    }
}