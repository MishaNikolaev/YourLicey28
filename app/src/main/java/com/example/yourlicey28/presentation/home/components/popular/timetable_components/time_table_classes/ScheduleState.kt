package com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.LessonInfo
import java.time.LocalDate

data class ScheduleState(
    val timetableList: List<List<LessonInfo>> = listOf()
//    val currentDate: LocalDate = LocalDate.now(),
//    val selectedDate: LocalDate = currentDate,
//    val lessonInfoList: List<LessonInfo> = emptyList(),
//    val isCalendarExpanded: Boolean = false
)