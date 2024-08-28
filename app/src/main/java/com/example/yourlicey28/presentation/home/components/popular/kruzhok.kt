package com.example.yourlicey28.presentation.home.components.popular

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KruzhokScreen(navController: NavHostController, isDarkThemeEnabled: Boolean) {
        val backgroundColor = if (isDarkThemeEnabled) Color(0xFF2C3E50) else Color.White
        val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray
        val images = listOf(R.drawable.psoiuihqjoa, R.drawable.pxl_20240613_092559954_mp, R.drawable.tenclass)

        Scaffold(
                modifier = Modifier.fillMaxSize().background(backgroundColor), // Применяем background напрямую к Scaffold
                content = { paddingValues ->
                        Column(
                                modifier = Modifier
                                        .fillMaxSize()
                                        .background(backgroundColor)
                                        .padding(paddingValues)
                                        .verticalScroll(rememberScrollState())
                        ) {
                                Text(
                                        modifier = Modifier
                                                .align(Alignment.CenterHorizontally)
                                                .padding(top = 10.dp, start = 10.dp),
                                        text = "МБОУ Лицей №28 получил статус официальной площадки НТО.",
                                        fontFamily = monterrat,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        color = textColor
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                ImageCarousel(images = images)
                                Text(
                                        modifier = Modifier
                                                .align(Alignment.CenterHorizontally)
                                                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                                        text = "На занятиях кружковцы индивидуально или в составе группы работают над отдельными (у каждого кружковца/группы разные) учебными или соревновательными задачами.",
                                        fontFamily = monterrat,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        color = textColor
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                        modifier = Modifier
                                                .align(Alignment.CenterHorizontally)
                                                .padding(start = 10.dp, end = 10.dp),
                                        text = "Расписание занятий:",
                                        fontFamily = monterrat,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 18.sp,
                                        color = LightBlueLC
                                )
                                Text(
                                        modifier = Modifier
                                                .align(Alignment.CenterHorizontally)
                                                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                                        text = "Вторник и пятница\n16:30 – 18:30,\nперерыв 19:00 – 20:30",
                                        fontFamily = monterrat,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 15.sp,
                                        color = textColor
                                )
                                Text(
                                        modifier = Modifier
                                                .align(Alignment.CenterHorizontally)
                                                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                                        text = "Посмотреть дополнительную информацию можно на сайте кружка28",
                                        fontFamily = monterrat,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 15.sp,
                                        color = textColor
                                )
                                ClickableLinkText(monterrat, isDarkThemeEnabled)
                                Spacer(modifier = Modifier.height(20.dp))
                        }
                }
        )
}

@Composable
fun ClickableLinkText(montserrat: FontFamily, isDarkThemeEnabled: Boolean) {
        val uriHandler = LocalUriHandler.current
        val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray

        val annotatedString = remember {
                buildAnnotatedString {
                        pushStringAnnotation(
                                tag = "URL",
                                annotation = "https://kruzhok28.ydns.eu/posts/info"
                        )
                        withStyle(
                                style = SpanStyle(
                                        color = LightBlueLC,
                                        fontWeight = FontWeight.SemiBold,
                                        textDecoration = TextDecoration.Underline,
                                )
                        ) {
                                append("https://kruzhok28.ydns.eu/posts/info")
                        }
                        pop()
                }
        }

        ClickableText(
                text = annotatedString,
                onClick = { offset ->
                        annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                                .firstOrNull()?.let { annotation ->
                                        uriHandler.openUri(annotation.item)
                                }
                },
                modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp),
                style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = montserrat,
                        fontSize = 15.sp,
                        color = Color.Blue
                )
        )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageCarousel(images: List<Int>) {
        val pagerState = rememberPagerState()
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
                while (true) {
                        yield()
                        delay(7000)
                        coroutineScope.launch {
                                pagerState.animateScrollToPage(
                                        page = (pagerState.currentPage + 1) % images.size
                                )
                        }
                }
        }

        val currentPage by remember { derivedStateOf { pagerState.currentPage } }

        Box(
                modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxWidth(0.95f)
                        .height(250.dp),
                contentAlignment = Alignment.Center
        ) {
                HorizontalPager(
                        count = images.size,
                        state = pagerState,
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                ) { page ->
                        Image(
                                painter = painterResource(id = images[page]),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                        .clip(RoundedCornerShape(20.dp))
                        )
                }

                Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                                .align(Alignment.BottomCenter) // Размещение внизу изображения
                                .padding(16.dp)
                ) {
                        repeat(images.size) { index ->
                                val color = if (index == currentPage) LightBlueLC else Color.LightGray
                                Canvas(
                                        modifier = Modifier
                                                .size(20.dp)
                                                .padding(4.dp),
                                        onDraw = {
                                                drawCircle(color = color)
                                        }
                                )
                        }
                }
        }
}