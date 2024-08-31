package com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.CalendarComponent
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.LessonCardList
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.LessonInfo
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.NothingAtAll
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import java.time.DayOfWeek
import java.time.LocalDate


@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel = hiltViewModel(),
    navController: NavController,
    state: ScheduleState
) {

    LazyColumn {
        items(state.timetableList){ elements->
            Column {
                for (el in elements){
                    Text(el.name)
                    Text(el.room)
                    Text(el.number)
                    Text(el.teacher)
                }
            }
        }
    }

    /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        // Заголовок и настройки
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
                text = "Расписание 1 А класса",
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
                    .clickable {},
                tint = LightBlueLC
            )
        }

        // Компонент календаря
        CalendarComponent(

        )

        // Отображение уроков
        if (state.lessonInfoList.isEmpty()) {
            NothingAtAll()
        } else {
            LessonCardList(state.lessonInfoList)
        }
    }

     */
}


val MondaylessonInfoList = listOf(
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

val ThursdaylessonInfoList = listOf(
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

val TuesdaylessonInfoList_3_a = listOf(
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

val WednesdaylessonInfoList_3_a = listOf(
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

val FridaylessonInfoList_3_a = listOf(
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

val SaturdaylessonInfoList_3_a = listOf(
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
    )
)


val first_a = listOf(
    MondaylessonInfoList, TuesdaylessonInfoList_3_a, WednesdaylessonInfoList_3_a,
    ThursdaylessonInfoList, FridaylessonInfoList_3_a, SaturdaylessonInfoList_3_a
)