package com.example.yourlicey28.presentation.home

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.activityComponents.WelcomeRoutes
import com.example.yourlicey28.ui.theme.BlueLC
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.chooseTheme.ThemeViewModel
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto
import kotlinx.coroutines.delay


data class Images(
    @DrawableRes val imageRes: Int,
    val title: String,
)

data class TitleDown(
    val title: String,
    val info: String,
    val bottomText: String
)

val imagesList = listOf(
    Images(
        imageRes = R.drawable.calendar,
        title = "Расписание",
    ),
    Images(
        imageRes = R.drawable.nti,
        title = "Кружок28",
    ),
    Images(
        imageRes = R.drawable.teacher_concept_illustration__1_,
        title = "Мои учителя",
    ),
)

val titleListDown = listOf(
    TitleDown(
        title = "Приём в 1 класс",
        info = "Планируется набор четырёх первых классов общей наполняемостью 120 человек. Предварительная запись производится по вторникам и четвергам с 8:30 до 11:30 по телефону 271-98-41.",
        bottomText = "Документы"
    ),
    TitleDown(
        title = "Приём в 10 класс",
        info = "Предварительная подача заявлений с 17.06.2024 г. по 25.06.2024 г." +
                "\nПрием и экспертиза представленных документов с 25.06.2024 г.  по 27.06.2024 г." +
                "\nИндивидуальное собеседование 28.06.2024 г.",
        bottomText = "Документы"
    ),
    TitleDown(
        title = "О лицее",
        info = "На протяжении многих лет в лицее реализуется концепция инженерного образования: с 5 класса начинается изучение физики, химии, информатики, с 7 – углубленное изучение математики, информатики, физики.",
        bottomText = "Документы"
    ),
)


@Composable
fun HomeScreen(
    navController: NavHostController,
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val isDarkThemeEnabled by themeViewModel.isDarkThemeEnabled.collectAsState()

    val backgroundColor = if (isDarkThemeEnabled) DarkLC else Color.White
    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray
    val cardBackgroundColor = if (isDarkThemeEnabled) DarkLC else Color.White
    val cardTextColor = if (isDarkThemeEnabled) Color.DarkGray else Color.DarkGray

    fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        context.startActivity(intent)
    }

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Популярное",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            items(imagesList.size) {
                ImagesItem(
                    it,
                    navController = navController,
                    isDarkThemeEnabled = isDarkThemeEnabled
                )
            }
        }
        Text(
            text = "Сервисы",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            items(titleListDown.size) {
                ImagesItemDown(
                    it,
                    navController = navController,
                    isDarkThemeEnabled = isDarkThemeEnabled
                )
            }
        }
        Text(
            text = "Сообщества",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )

        // Card 1
        Card(
            modifier = Modifier
                .padding(top = 15.dp, start = 20.dp)
                .fillMaxWidth(0.95f)
                .height(100.dp)
                .clickable {
                    openUrl("https://lic28nsk.edusite.ru/")
                },
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(4.dp),
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(cardBackgroundColor)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFE3F2FD), Color(0xFFFFF9C4))
                            )
                        )
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.m_liceyphoto),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(50.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Лицей №28",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = cardTextColor, // Изменено здесь
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Text(
                        text = "Перейти на официальный сайт",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = cardTextColor, // Изменено здесь
                        modifier = Modifier
                            .padding(start = 50.dp)
                            .align(Alignment.Start)
                    )
                }
            }
        }

        // Card 2
        Card(
            modifier = Modifier
                .padding(top = 15.dp, start = 20.dp)
                .fillMaxWidth(0.95f)
                .height(100.dp)
                .clickable {
                    openUrl("https://vk.com/club217483566")
                },
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(4.dp),
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(cardBackgroundColor)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFE6E6FA), Color(0xFFB0E0E6))
                            )
                        )
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pabe9y0mis4f64xs),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(50.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Сообщество Лицея №28",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = cardTextColor, // Изменено здесь
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Text(
                        text = "Перейти в сообщество лицея ВКонтакте",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = cardTextColor, // Изменено здесь
                        modifier = Modifier
                            .padding(start = 50.dp)
                            .align(Alignment.Start)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun ImagesItem(
    index: Int,
    navController: NavHostController,
    isDarkThemeEnabled: Boolean
) {
    val images = imagesList[index]

    val backgroundColor = when (images.title) {
        "Расписание" -> if (isDarkThemeEnabled) DarkLC else Color.White
        "Кружок28" -> if (isDarkThemeEnabled) DarkLC else Color.White
        "Мои учителя" -> if (isDarkThemeEnabled) DarkLC else Color.White
        else -> if (isDarkThemeEnabled) DarkLC else Color.White
    }

    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(125.dp)
            .height(125.dp)
            .clickable {
                when (images.title) {
                    "Расписание" -> navController.navigate(WelcomeRoutes.TimeTableScreen.route)
                    "Кружок28" -> navController.navigate(WelcomeRoutes.KruzhokScreen.route)
                    "Мои учителя" -> navController.navigate(WelcomeRoutes.MyTeachersScreen.route)
                    else -> {}
                }
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = Modifier
                .background(backgroundColor)
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = images.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(83.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = images.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
@Composable
fun ImagesItemDown(
    index: Int,
    navController: NavHostController,
    isDarkThemeEnabled: Boolean
) {
    val context = LocalContext.current
    val titleDown = titleListDown[index]
    val backgroundColor = if (isDarkThemeEnabled) {
        when (titleDown.title) {
            "Приём в 1 класс" -> Brush.linearGradient(
                colors = listOf(Color(0xFFC7F1C8), Color(0xFFB3E5FC)),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
            "Приём в 10 класс" -> Brush.linearGradient(
                colors = listOf(Color(0xFFFDBAD1), Color(0xFFFF4081)),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
            "О лицее" -> Brush.linearGradient(
                colors = listOf(Color(0xFFFFE8A5), Color(0xFFFFC107)),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
            else -> Brush.linearGradient(
                colors = listOf(Color.White, Color.LightGray),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
        }
    } else {
        when (titleDown.title) {
            "Приём в 1 класс" -> Brush.linearGradient(
                colors = listOf(Color(0xFFC7F1C8), Color(0xFFB3E5FC)),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
            "Приём в 10 класс" -> Brush.linearGradient(
                colors = listOf(Color(0xFFFDBAD1), Color(0xFFFF4081)),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
            "О лицее" -> Brush.linearGradient(
                colors = listOf(Color(0xFFFFE8A5), Color(0xFFFFC107)),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
            else -> Brush.linearGradient(
                colors = listOf(Color.White, Color.LightGray),
                start = Offset(0f, 0f),
                end = Offset(1000f, 1000f)
            )
        }
    }

    val textColor = if (isDarkThemeEnabled) Color.DarkGray else Color.DarkGray

    fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        context.startActivity(intent)
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(start = 10.dp)
            .width(300.dp)
            .height(170.dp)
            .clickable {
                when (titleDown.title) {
                    "Приём в 1 класс" -> navController.navigate(WelcomeRoutes.EnterToFirstClass.route)
                    "Приём в 10 класс" -> navController.navigate(WelcomeRoutes.EnterToTenClass.route)
                    "О лицее" -> navController.navigate(WelcomeRoutes.AboutSchool.route)
                    else -> {}
                }
            },
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .background(backgroundColor)
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Text(
                text = titleDown.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                fontFamily = roboto,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = titleDown.info,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = textColor,
                fontFamily = roboto,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        when (titleDown.title) {
                            "Приём в 1 класс" -> openUrl("https://lic28nsk.edusite.ru/DswMedia/1klass-1.pdf")
                            "Приём в 10 класс" -> openUrl("https://lic28nsk.edusite.ru/DswMedia/oborganizaciipriemav10kl.pdf")
                            "О лицее" -> openUrl("https://lic28nsk.edusite.ru/p122aa1.html")
                            else -> {}
                        }
                    }
                    .height(40.dp)
                    .width(95.dp)
                    .background(if (isDarkThemeEnabled) Color.DarkGray else textColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = titleDown.bottomText,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = if (isDarkThemeEnabled) Color.White else Color.White,
                    fontFamily = roboto,
                )
            }
        }
    }
}
