package com.example.yourlicey28.presentation.welcome

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.activityComponents.WelcomeRoutes
import com.example.yourlicey28.ui.theme.BlueLC
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto

@Composable
fun WelcomeScreenFirst(navController: NavController) {
    Column(
        modifier = Modifier
            .background(DarkBlueLC)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.rocket),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(400.dp)
                .width(400.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Добро" +
                    "\nпожаловать!",
            fontSize = 40.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Это приложение создано" +
                    "\nдля школьников Лицея №28",
            fontSize = 16.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row() {
            ClickableText(
                text = AnnotatedString("Пропустить"),
                onClick = {
                    navController.navigate(WelcomeRoutes.NewsScreen.route)
                },
                style = LocalTextStyle.current.copy(
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp,
                ), modifier = Modifier.padding(start = 20.dp,top = 10.dp)
            )
            Spacer(modifier = Modifier.width(180.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .size(45.dp)
                    .background(BlueLC)
                    .clickable {
                        navController.navigate(WelcomeRoutes.WelcomeScreenSecond.route)
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Add Icon",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val circles = listOf(true, false, false)
            circles.forEachIndexed { index, isActive ->
                Box(
                    modifier = Modifier
                        .size(if (isActive) 12.dp else 12.dp)
                        .background(
                            color = if (isActive) Color.White else Color.Gray,
                            shape = CircleShape
                        )
                )
                if (index < circles.lastIndex) {
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}



@Composable
fun WelcomeScreenSecond(navController: NavController) {
    Column(
        modifier = Modifier
            .background(DarkBlueLC)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.education),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(340.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Смотри" +
                    "\nрасписание!",
            fontSize = 40.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Можно легко посмотреть своё расписание, не тратя своё драгоценное время!",
            fontSize = 16.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row() {
            ClickableText(
                text = AnnotatedString("Пропустить"),
                onClick = {
                    navController.navigate(WelcomeRoutes.NewsScreen.route)
                },
                style = LocalTextStyle.current.copy(
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp,
                ), modifier = Modifier.padding(start = 20.dp,top = 10.dp)
            )
            Spacer(modifier = Modifier.width(180.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .size(45.dp)
                    .background(BlueLC)
                    .clickable {
                        navController.navigate(WelcomeRoutes.WelcomeScreenThird.route)
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Add Icon",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val circles = listOf(false, true, false)
            circles.forEachIndexed { index, isActive ->
                Box(
                    modifier = Modifier
                        .size(if (isActive) 12.dp else 12.dp)
                        .background(
                            color = if (isActive) Color.White else Color.Gray,
                            shape = CircleShape
                        )
                )
                if (index < circles.lastIndex) {
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}


@Composable
fun WelcomeScreenThird(
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .background(DarkBlueLC)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.saly_18),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(380.dp)
                .width(380.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Будь в курсе в любой момент!",
            fontSize = 35.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Часто бывает, что заходить на сайт и искать там информацию лень. Тут это быстро!",
            fontSize = 16.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Spacer(modifier = Modifier.width(240.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .size(45.dp)
                    .background(BlueLC)
                    .clickable {
                        viewModel.beginClicked()
                        navController.navigate(WelcomeRoutes.NewsScreen.route)
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Add Icon",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val circles = listOf(false, false, true)
            circles.forEachIndexed { index, isActive ->
                Box(
                    modifier = Modifier
                        .size(if (isActive) 12.dp else 12.dp)
                        .background(
                            color = if (isActive) Color.White else Color.Gray,
                            shape = CircleShape
                        )
                )
                if (index < circles.lastIndex) {
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}