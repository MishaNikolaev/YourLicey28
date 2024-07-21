package com.example.yourlicey28.presentation.welcome

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.util.Devices.OPENED_FIRST
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var state by mutableStateOf(WelcomeState())

    init {
        viewModelScope.launch {
            val dataStoreValue = repository.readValue(OPENED_FIRST)
            if (dataStoreValue != null) {
                state = state.copy(isInitial = 1)
            }
            state = state.copy(finished = true)
        }
    }
}