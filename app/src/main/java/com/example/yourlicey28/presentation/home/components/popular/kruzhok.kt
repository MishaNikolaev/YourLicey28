package com.example.yourlicey28.presentation.home.components.popular

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.yourlicey28.ui.theme.monterrat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KruzhokScreen(navController: NavHostController, isDarkThemeEnabled : Boolean) {
        val backgroundColor = if (isDarkThemeEnabled) Color(0xFF2C3E50) else Color.White

        val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray
        Column(modifier = Modifier.verticalScroll(rememberScrollState()).background(backgroundColor)) {
                Image(
                        painter = painterResource(R.drawable.psoiuihqjoa),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .width(256.dp)
                                .height(256.dp)
                                .clip(
                                        RoundedCornerShape(
                                                20.dp
                                        )
                                )
                )
                Text(
                        modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                        text = "МБОУ Лицей №28 получил статус официальной площадки НТО. На занятиях кружковцы индивидуально или в составе группы работают над отдельными (у каждого кружковца/группы разные) учебными или соревновательными задачами. Преподаватели разбирают материал с такими группами, последовательно переключаясь между ними. Такой формат позволяет каждому ученику развиваться по своей собственной траектории, которая обсуждается с каждым учеником в начале и середине учебного года.",
                        fontFamily = monterrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = textColor
                )
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                        painter = painterResource(R.drawable.rectangle_90),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .width(256.dp)
                                .height(256.dp)
                                .clip(
                                        RoundedCornerShape(
                                                20.dp
                                        )
                                )
                )
                Text(
                        modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                        text = "Расписание занятий:\n" +
                                "Вторник и пятница\n" +
                                "16:30 – 18:30, \n" +
                                "перерыв 19:00 – 20:30",
                        fontFamily = monterrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = textColor
                )
                ClickableLinkText(monterrat)
                Spacer(modifier = Modifier.height(20.dp))
        }
}
@Composable
fun ClickableLinkText(montserrat: FontFamily) {
        val uriHandler = LocalUriHandler.current

        val annotatedString = remember {
                buildAnnotatedString {
                        append("Запись происходит на сайте кружка28 -")
                        pushStringAnnotation(
                                tag = "URL",
                                annotation = "https://kruzhok28.ydns.eu/posts/info"
                        )
                        withStyle(
                                style = SpanStyle(
                                        color = Color.Blue,
                                        fontWeight = FontWeight.SemiBold,
                                        textDecoration = TextDecoration.Underline
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
                modifier = Modifier

                        .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = montserrat,
                        fontSize = 12.sp,
                        color = Color.DarkGray
                )
        )
}