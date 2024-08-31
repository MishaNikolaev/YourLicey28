package com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.yourlicey28.domain.repository.Repository
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.LessonInfo
import com.example.yourlicey28.presentation.news.certain_news.NewsDetailsEvent
import com.example.yourlicey28.presentation.news.certain_news.NewsStateDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.DayOfWeek
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(ScheduleState())
    val state: State<ScheduleState> get() = _state

    init {
        val schedule = savedStateHandle.get<String>("schedule")

        schedule?.let {
            when (schedule){
                "1 А" -> {
                    _state.value=_state.value.copy(timetableList = first_a)
                }
            }
        }
    }

}