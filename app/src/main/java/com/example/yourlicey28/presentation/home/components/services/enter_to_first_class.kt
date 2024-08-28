package com.example.yourlicey28.presentation.home.components.services

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.monterrat

@Composable
fun EnterToFirstClass(navController: NavHostController, isDarkThemeEnabled : Boolean) {
    val backgroundColor = if (isDarkThemeEnabled) Color(0xFF2C3E50) else Color.White
    val textColor = if (isDarkThemeEnabled) Color.White else Color.DarkGray
    Column(modifier = Modifier.verticalScroll(rememberScrollState()).background(backgroundColor)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.frame_firstclass),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 25.dp,
                            bottomEnd = 25.dp
                        )
                    )
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            text = "Подать документы на прием в 1 класс одним из следующих способов:",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = textColor
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            text = "1) Лично в образовательную организацию (по предварительной записи)\n" +
                    "\n2) Через портал государственных услуг РФ. \n" +
                    "\n3) Заказным письмом с уведомлением о вручении Прием документов в 1 класс производится на 2 этаже в кабинете секретаря по предварительной записи",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = textColor
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(R.drawable.firstclass1),
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
            text = "Оригиналы указанных документов иметь при себе. Приказ о зачислении издается  после завершения  приема заявлений.\n",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = textColor
        )
    }
}