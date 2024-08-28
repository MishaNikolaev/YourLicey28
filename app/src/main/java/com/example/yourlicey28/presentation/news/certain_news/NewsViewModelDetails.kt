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
import com.example.yourlicey28.util.Resource
import kotlinx.coroutines.flow.collectLatest

private const val TAG = "NewsViewModelDetail"

@HiltViewModel
class NewsViewModelDetails @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(NewsStateDetails())
    val state: State<NewsStateDetails> get() = _state

    init {
        val id = savedStateHandle.get<Int>("id")
        id?.let {
            processEvent(NewsDetailsEvent.GetNews(id = it))
        }
    }

    fun processEvent(event: NewsDetailsEvent) {
        when (event) {
            is NewsDetailsEvent.GetNews -> getNews(event.id)
        }
    }

    private fun getNews(id: Int) {
        viewModelScope.launch {
            repository.getNews(id).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = result.isLoading)
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            newsDetail = result.data,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}