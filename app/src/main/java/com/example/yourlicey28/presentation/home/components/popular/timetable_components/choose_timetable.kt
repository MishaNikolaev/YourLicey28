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
import com.example.yourlicey28.presentation.home.titleListDown
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto
data class ClassInfo(val info: String)

@Composable
fun ChooseTimeTable(navController: NavController,isDarkThemeEnabled : Boolean ) {
    val backgroundColor = if (isDarkThemeEnabled) DarkLC else Color.White

    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray
    Column(modifier = Modifier.background(backgroundColor)) {
        Row {
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "Выберите свой класс",
                fontSize = 18.sp,
                fontFamily = monterrat,
                textAlign = TextAlign.Center,
                color = textColor,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 25.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(classList) { classInfo ->
                ClassCard(
                    classInfo = classInfo,
                    navController = navController,
                    isDarkThemeEnabled
                )
            }
        }
    }
}

val classList = listOf(
    // First classes
    ClassInfo(info = "1 А"), ClassInfo(info = "1 Б"), ClassInfo(info = "1 В"), ClassInfo(info = "1 Г"), ClassInfo(info = "1 Д"),
    // Second classes
    ClassInfo(info = "2 А"), ClassInfo(info = "2 Б"), ClassInfo(info = "2 В"), ClassInfo(info = "2 Г"),
    // Third classes
    ClassInfo(info = "3 А"), ClassInfo(info = "3 Б"), ClassInfo(info = "3 В"), ClassInfo(info = "3 Г"),
    // Fourth classes
    ClassInfo(info = "4 А"), ClassInfo(info = "4 Б"), ClassInfo(info = "4 В"), ClassInfo(info = "4 Г"),
    // Fifth classes
    ClassInfo(info = "5 А"), ClassInfo(info = "5 Б"), ClassInfo(info = "5 В"), ClassInfo(info = "5 Г"),
    // Sixth classes
    ClassInfo(info = "6 А"), ClassInfo(info = "6 Б"), ClassInfo(info = "6 В"), ClassInfo(info = "6 Г"),
    // Seventh classes
    ClassInfo(info = "7 А"), ClassInfo(info = "7 Б"), ClassInfo(info = "7 В"), ClassInfo(info = "7 Г"), ClassInfo(info = "7 ИТ"),
    // Eighth classes
    ClassInfo(info = "8 А"), ClassInfo(info = "8 Б"), ClassInfo(info = "8 В"), ClassInfo(info = "8 Г"), ClassInfo(info = "8 ИТ"),
    // Ninth classes
    ClassInfo(info = "9 А"), ClassInfo(info = "9 Б"), ClassInfo(info = "9 В"), ClassInfo(info = "9 Г"), ClassInfo(info = "9 ИТ"),
    // Tenth classes
    ClassInfo(info = "10 А"), ClassInfo(info = "10 Б"), ClassInfo(info = "10 В"),
    // Eleventh classes
    ClassInfo(info = "11 А"), ClassInfo(info = "11 Б"), ClassInfo(info = "11 В")
)

@Composable
fun ClassCard(classInfo: ClassInfo, navController: NavController, isDarkThemeEnabled: Boolean) {
    val backgroundColor = if (isDarkThemeEnabled) DarkLC else Color.White
    val backgroundColorSecond = if (isDarkThemeEnabled) Color(0xFF2C3E50) else Color.White
    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray
    Card(
        modifier = Modifier.background(backgroundColor)
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                when (classInfo.info) {
                    "1 А" -> navController.navigate(WelcomeRoutes.ScheduleScreen.route + "?schedule=${classInfo.info}")
                    "1 Б" -> navController.navigate(WelcomeRoutes.ScheduleScreen.route+ "?schedule=${classInfo.info}")
                    "1 В" -> navController.navigate(WelcomeRoutes.ScheduleScreen.route+ "?schedule=${classInfo.info}")
                    "1 Г" -> navController.navigate(WelcomeRoutes.ScheduleScreen.route+ "?schedule=${classInfo.info}")
                    "1 Д" -> navController.navigate(WelcomeRoutes.ScheduleScreen.route+ "?schedule=${classInfo.info}")

                    /*"2 А" -> navController.navigate(WelcomeRoutes.SecondAClass.route)
                    "2 Б" -> navController.navigate(WelcomeRoutes.SecondBClass.route)
                    "2 В" -> navController.navigate(WelcomeRoutes.SecondVClass.route)
                    "2 Г" -> navController.navigate(WelcomeRoutes.SecondtGClass.route)

                    "3 А" -> navController.navigate(WelcomeRoutes.ThirdAClass.route)
                    "3 Б" -> navController.navigate(WelcomeRoutes.ThirdBClass.route)
                    "3 В" -> navController.navigate(WelcomeRoutes.ThirdVClass.route)
                    "3 Г" -> navController.navigate(WelcomeRoutes.ThirdGClass.route)

                    "4 А" -> navController.navigate(WelcomeRoutes.ForthAClass.route)
                    "4 Б" -> navController.navigate(WelcomeRoutes.ForthBClass.route)
                    "4 В" -> navController.navigate(WelcomeRoutes.ForthVClass.route)
                    "4 Г" -> navController.navigate(WelcomeRoutes.ForthGClass.route)

                    "5 А" -> navController.navigate(WelcomeRoutes.FivethAClass.route)
                    "5 Б" -> navController.navigate(WelcomeRoutes.FivethBClass.route)
                    "5 В" -> navController.navigate(WelcomeRoutes.FivethVClass.route)
                    "5 Г" -> navController.navigate(WelcomeRoutes.FivethGClass.route)
                       */
                    else -> {}
                }
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(backgroundColorSecond)
    ) {
        Row(
            modifier = Modifier.background(backgroundColorSecond)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = classInfo.info,
                fontSize = 18.sp,
                fontFamily = roboto,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )
        }
    }
}