package com.example.yourlicey28.presentation.home.components.popular.timetable_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.yourlicey28.presentation.activityComponents.WelcomeRoutes
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto

data class ClassInfo(val number: Int, val symbol: String)

@Composable
fun ChooseTimeTable(navController: NavController) {
    Column {
        Row {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 20.dp, top = 20.dp)
                    .clickable {
                        navController.navigate(WelcomeRoutes.TimeTableScreen.route)
                    }
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "Выберите свой класс",
                fontSize = 18.sp,
                fontFamily = monterrat,
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 25.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(classList) { classInfo ->
                ClassCard(classInfo = classInfo)
            }
        }
    }
}

val classList = listOf(
    //First classes
    ClassInfo(number = 1, symbol = "A"),
    ClassInfo(number = 1, symbol = "Б"),
    ClassInfo(number = 1, symbol = "В"),
    ClassInfo(number = 1, symbol = "Г"),
    ClassInfo(number = 1, symbol = "Д"),
    //Second classes
    ClassInfo(number = 2, symbol = "А"),
    ClassInfo(number = 2, symbol = "Б"),
    ClassInfo(number = 2, symbol = "В"),
    ClassInfo(number = 2, symbol = "Г"),
    //Third classes
    ClassInfo(number = 3, symbol = "А"),
    ClassInfo(number = 3, symbol = "Б"),
    ClassInfo(number = 3, symbol = "В"),
    ClassInfo(number = 3, symbol = "Г"),
    //4th classes
    ClassInfo(number = 4, symbol = "А"),
    ClassInfo(number = 4, symbol = "Б"),
    ClassInfo(number = 4, symbol = "В"),
    ClassInfo(number = 4, symbol = "Г"),
    //5th classes
    ClassInfo(number = 5, symbol = "А"),
    ClassInfo(number = 5, symbol = "Б"),
    ClassInfo(number = 5, symbol = "В"),
    ClassInfo(number = 5, symbol = "Г"),
    //6th classes
    ClassInfo(number = 6, symbol = "А"),
    ClassInfo(number = 6, symbol = "Б"),
    ClassInfo(number = 6, symbol = "В"),
    ClassInfo(number = 6, symbol = "Г"),
    //7th classes
    ClassInfo(number = 7, symbol = "А"),
    ClassInfo(number = 7, symbol = "Б"),
    ClassInfo(number = 7, symbol = "В"),
    ClassInfo(number = 7, symbol = "Г"),
    ClassInfo(number = 7, symbol = "ИТ"),
    //8th classes
    ClassInfo(number = 8, symbol = "А"),
    ClassInfo(number = 8, symbol = "Б"),
    ClassInfo(number = 8, symbol = "В"),
    ClassInfo(number = 8, symbol = "Г"),
    ClassInfo(number = 8, symbol = "ИТ"),
    //9th classes
    ClassInfo(number = 9, symbol = "А"),
    ClassInfo(number = 9, symbol = "Б"),
    ClassInfo(number = 9, symbol = "В"),
    ClassInfo(number = 9, symbol = "Г"),
    //10th classes
    ClassInfo(number = 10, symbol = "А"),
    ClassInfo(number = 10, symbol = "Б"),
    ClassInfo(number = 10, symbol = "В"),
    //10th classes
    ClassInfo(number = 11, symbol = "А"),
    ClassInfo(number = 11, symbol = "Б"),
)
@Composable
fun ClassCard(classInfo: ClassInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier.clickable {

            }
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${classInfo.number} ${classInfo.symbol}",
                fontSize = 18.sp,
                fontFamily = roboto,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}