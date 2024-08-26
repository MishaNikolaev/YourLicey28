package com.example.yourlicey28.ui.theme.chooseTheme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themeDataStore: TutorialThemeDataStore
) : ViewModel() {

    val isDarkThemeEnabled: StateFlow<Boolean> = themeDataStore.isDarkThemeEnabled.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = false
    )

    fun setDarkThemeEnabled(enabled: Boolean) = viewModelScope.launch {
        themeDataStore.enableDarkTheme(enabled)
    }
}