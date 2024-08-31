package com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes

import java.time.LocalDate

sealed class ScheduleEvent {
    data class DateSelected(val date: LocalDate) : ScheduleEvent()
    data class MonthChanged(val delta: Int) : ScheduleEvent()
    object ToggleCalendar : ScheduleEvent()
}