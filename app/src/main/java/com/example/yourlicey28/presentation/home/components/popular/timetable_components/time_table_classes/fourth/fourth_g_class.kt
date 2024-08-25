package com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.fourth

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.yourlicey28.presentation.activityComponents.WelcomeRoutes
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.CalendarComponent
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.LessonCard
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.LessonCardList
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.LessonInfo
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.NothingAtAll
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import java.time.DayOfWeek
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Fourth_G_Class(navController: NavHostController) {
    val currentDate = remember { mutableStateOf(LocalDate.now()) }
    val selectedDate = remember { mutableStateOf(currentDate.value) }
    val currentMonthStart = remember { mutableStateOf(currentDate.value.withDayOfMonth(1)) }
    val isCalendarExpanded = remember { mutableStateOf(false) }

    val currentDayOfWeek = selectedDate.value.dayOfWeek

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                modifier = Modifier.padding(),
                text = "Расписание 4 Г класса",
                fontFamily = monterrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.DarkGray
            )

            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                modifier = Modifier
                    .size(30.dp)
                    .padding()
                    .clickable {
                    },
                tint = LightBlueLC
            )
        }

        CalendarComponent(
            currentMonthStart.value,
            currentDate.value,
            selectedDate.value,
            onDateSelected = { selectedDate.value = it },
            onMonthChange = { delta ->
                currentMonthStart.value = currentMonthStart.value.plusMonths(delta.toLong())
            },
            isExpanded = isCalendarExpanded.value,
            onExpandToggle = { isCalendarExpanded.value = !isCalendarExpanded.value }
        )

        when (currentDayOfWeek) {
            DayOfWeek.MONDAY -> LessonCardList(MondaylessonInfoList_4_g)
            DayOfWeek.TUESDAY -> LessonCardList(ThuesdaylessonInfoList_4_g)
            DayOfWeek.WEDNESDAY -> LessonCardList(WednesdaylessonInfoList_4_g)
            DayOfWeek.THURSDAY -> LessonCardList(ThursdaylessonInfoList_4_g)
            DayOfWeek.FRIDAY -> LessonCardList(FridaylessonInfoList_4_g)
            DayOfWeek.SATURDAY -> LessonCardList(SaturdaylessonInfoList_4_g)
            DayOfWeek.SUNDAY -> NothingAtAll()
        }
    }
}


val MondaylessonInfoList_4_g = listOf(
    LessonInfo(
        name = "Технология",
        number = "1 урок            в 8:00 - 8:40",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Математика",
        number = "2 урок            в 8:50 - 9:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Окружающий мир",
        number = "3 урок            в 9:50 - 10:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Русский язык",
        number = "4 урок            в 10:40 - 11:20",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),

    )

val ThursdaylessonInfoList_4_g = listOf(
    LessonInfo(
        name = "Математика",
        number = "1 урок            в 8:00 - 8:40",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Математика",
        number = "2 урок            в 8:50 - 9:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Окружающий мир",
        number = "3 урок            в 9:50 - 10:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Русский язык",
        number = "4 урок            в 10:40 - 11:20",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),

    )

val ThuesdaylessonInfoList_4_g = listOf(
    LessonInfo(
        name = "Технология",
        number = "1 урок            в 8:00 - 8:40",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Математика",
        number = "2 урок            в 8:50 - 9:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Окружающий мир",
        number = "3 урок            в 9:50 - 10:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Русский язык",
        number = "4 урок            в 10:40 - 11:20",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),

    )

val WednesdaylessonInfoList_4_g = listOf(
    LessonInfo(
        name = "Русский язык",
        number = "1 урок            в 8:00 - 8:40",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Математика",
        number = "2 урок            в 8:50 - 9:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Окружающий мир",
        number = "3 урок            в 9:50 - 10:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Математика",
        number = "4 урок            в 10:40 - 11:20",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),

    )

val FridaylessonInfoList_4_g = listOf(
    LessonInfo(
        name = "Литература",
        number = "1 урок            в 8:00 - 8:40",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Окружающий мир",
        number = "2 урок            в 8:50 - 9:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Математика",
        number = "3 урок            в 9:50 - 10:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Русский язык",
        number = "4 урок            в 10:40 - 11:20",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),

    )

val SaturdaylessonInfoList_4_g = listOf(
    LessonInfo(
        name = "Литература",
        number = "1 урок            в 8:00 - 8:40",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Окружающий мир",
        number = "2 урок            в 8:50 - 9:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Математика",
        number = "3 урок            в 9:50 - 10:30",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),
    LessonInfo(
        name = "Русский язык",
        number = "4 урок            в 10:40 - 11:20",
        room = "каб. 103",
        teacher = "Лукьянова Лариса Михайловна"
    ),

    )