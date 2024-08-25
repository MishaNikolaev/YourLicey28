package com.example.yourlicey28.presentation.home.components.popular.timetable_components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarComponent(
    currentMonth: LocalDate,
    today: LocalDate,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    onMonthChange: (Int) -> Unit,
    isExpanded: Boolean,
    onExpandToggle: () -> Unit
) {
    val formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale("ru"))
    val startOfMonth = currentMonth.withDayOfMonth(1)
    val startOfWeek = startOfMonth.with(DayOfWeek.MONDAY)
    val daysInMonth = currentMonth.lengthOfMonth()
    val daysInGrid = if (startOfWeek.dayOfMonth + 35 < daysInMonth) 42 else 35
    val dates = List(daysInGrid) { startOfWeek.plusDays(it.toLong()) }

    // Находим индекс недели, содержащей сегодняшнюю дату
    val weekContainingTodayIndex = dates.chunked(7).indexOfFirst { week ->
        week.any { date -> date == today }
    }

    val dateChunks = if (weekContainingTodayIndex != -1) {
        dates.chunked(7).drop(weekContainingTodayIndex)
    } else {
        dates.chunked(7)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { onMonthChange(-1) }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Previous Month", tint = LightBlueLC)
            }
            Text(
                text = currentMonth.format(formatter),
                fontFamily = monterrat,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
            IconButton(onClick = { onMonthChange(1) }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next Month", tint = LightBlueLC)
            }
            IconButton(onClick = { onExpandToggle() }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse Calendar" else "Expand Calendar",
                    tint = LightBlueLC
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val daysOfWeek = listOf("пн", "вт", "ср", "чт", "пт", "сб", "вс")
            daysOfWeek.forEach { day ->
                Text(
                    text = day,
                    fontFamily = roboto,
                    fontSize = 14.sp,
                    color = Color(0xFF888899)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            dateChunks.firstOrNull()?.let { week ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    week.forEach { date ->
                        val isSelected = date == selectedDate
                        val textColor = if (date.month == currentMonth.month) Color.DarkGray else Color.LightGray
                        val backgroundColor = when {
                            date == today -> LightBlueLC
                            isSelected -> LightBlueLC.copy(alpha = 0.5f)
                            else -> Color.Transparent
                        }

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(backgroundColor, shape = CircleShape)
                                .clickable { onDateSelected(date) }
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = date.dayOfMonth.toString(),
                                fontFamily = monterrat,
                                fontSize = 14.sp,
                                color = textColor
                            )
                        }
                    }
                }
            }
            if (isExpanded) {
                val remainingWeeks = dateChunks.drop(1)
                remainingWeeks.forEach { week ->
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                        week.forEach { date ->
                            val isSelected = date == selectedDate
                            val textColor = if (date.month == currentMonth.month) Color(0xFF888899) else Color.LightGray
                            val backgroundColor = when {
                                date == today -> LightBlueLC
                                isSelected -> LightBlueLC.copy(alpha = 0.5f)
                                else -> Color.Transparent
                            }

                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .background(backgroundColor, shape = CircleShape)
                                    .clickable { onDateSelected(date) }
                                    .padding(8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = date.dayOfMonth.toString(),
                                    fontFamily = monterrat,
                                    fontSize = 14.sp,
                                    color = textColor
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LessonCard(lessonInfo: LessonInfo) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = lessonInfo.name,
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = roboto,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = lessonInfo.number,
                color = Color(0xFF766EAD),
                fontSize = 14.sp,
                fontFamily = roboto,
                fontWeight = FontWeight.W400
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                thickness = 1.dp,
                color = Color(0xFFF5F5F5)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Icon(
                    imageVector = Icons.Default.Map,
                    contentDescription = "Map",
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .size(15.dp),
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = lessonInfo.room,
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.W400
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person",
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .size(15.dp),
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = lessonInfo.teacher,
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun NothingAtAll(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.saly_18),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Сегодня у вас нет занятий",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Советуем выполнить домашнее задание.",
            fontSize = 16.sp,
            fontFamily = roboto,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

data class LessonInfo(
    val name: String,
    val number: String,
    val room: String,
    val teacher: String
)

@Composable
fun LessonCardList(lessonInfoList: List<LessonInfo>) {
    Column {
        for (lessonInfo in lessonInfoList) {
            LessonCard(lessonInfo = lessonInfo)
        }
    }
}