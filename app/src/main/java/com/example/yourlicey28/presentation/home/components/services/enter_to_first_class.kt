package com.example.yourlicey28.presentation.home.components.services

import androidx.compose.foundation.Image
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
import com.example.yourlicey28.ui.theme.monterrat

@Composable
fun EnterToFirstClass(navController: NavHostController) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
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
            text = "Планируется набор четырёх первых классов общей наполняемостью 120 человек. Предварительная запись производится по вторникам и четвергам с 8:30 до 11:30 по телефону 271-98-41. ",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.DarkGray
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            text = "Подать документы на прием в 1 класс одним из следующих способов: \n" +
                    "1) Лично в образовательную организацию (по предварительной записи)\n" +
                    "2) Через портал государственных услуг РФ. \n" +
                    "3) Заказным письмом с уведомлением о вручении Прием документов в 1 класс производится на 2 этаже в кабинете секретаря по предварительной записи",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.DarkGray
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
            text = "Для приема родитель(и) (законный(ые) представитель(и) ребенка или поступающий представляют следующие документы:\n" +
                    "\n" +
                    "-Заявление родителей (законных представителей)\n" +
                    " -Копию документа, удостоверяющего личность родителей (законных представителей)\n" +
                    "-Копию свидетельства о рождении ребенка\n" +
                    "-Копию свидетельства о регистрации ребёнка по месту жительства (Форма № 8) и свидетельство о регистрации по месту         пребывания (форма № 3)\n" +
                    "-Справку с места работы родителя (законного представителя) при наличии права внеочередного  приема на обучение -Документ, подтверждающий общее место жительства  и  проживание в одной семье (для детей, старшие братья/сестры, которых уже  обучаются в  лицее). \n" +
                    "\n" +
                    "Оригиналы указанных документов иметь при себе. Приказ о зачислении издается  после завершения  приема заявлений.\n",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.DarkGray
        )
    }
}