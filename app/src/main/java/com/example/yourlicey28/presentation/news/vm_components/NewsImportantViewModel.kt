package com.example.yourlicey28.presentation.news.vm_components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.presentation.welcome.WelcomeState
import com.example.yourlicey28.ui.theme.chooseTheme.TutorialThemeDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsImportantViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(ImportantState())

    init {
        viewModelScope.launch {
            repository.getImportant().collect { newsList ->
                state = state.copy(newsList = newsList)
            }
        }
    }
}