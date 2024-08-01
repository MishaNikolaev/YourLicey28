package com.example.yourlicey28.presentation.news

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.model.News
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "NewsViewModel"

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var state by mutableStateOf(NewsState())

    init {
        viewModelScope.launch {
            val news = repository
                .getNews()
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { news ->
                                state = state.copy(news = news)
                                for (n in news) {
                                    Log.d(TAG, "${n}")
                                }
                            }
                        }

                        is Resource.Error -> {
                            result.message?.let { errorMessage ->
                                state = state.copy(error = errorMessage)
                            }
                        }

                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }

    fun onLickeClicked(news: News) {
        viewModelScope.launch {
            Log.d(TAG, "onLickeClicked: ${news}")
            repository.update(news = news.copy(favourite = !news.favourite))
        }
    }
}