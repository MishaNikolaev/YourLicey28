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
fun EnterToTenClass(navController: NavHostController){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.frame_610),
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
            text = "Прием осуществляется в три этапа: \n" +
                    "1.  Предварительная подача заявлений с 17.06.2024 г. по 25.06.2024 г.\n" +
                    "2. Прием и экспертиза представленных документов с 25.06.2024 г.  по 27.06.2024 г.\n" +
                    "3. Индивидуальное собеседование 28.06.2024 г.\n" +
                    "Решение о зачислении учащихся на основании протокола комиссии по результатам индивидуального отбора (рейтинга) 01.07.2024 г.",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(R.drawable.rectangle_93),
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
            text = "10 \"А\". Профиль: технологический\n" +
                    "(с углубленным изучением предметов \"математика\", \"информатика\", \"физика\")\n" +
                    "\n" +
                    "10 \"Б\" мультипрофильный\n" +
                    "\n" +
                    "- естественно - научный\n" +
                    "(с углубленным изучением предметов \"математика\", \"химия\", \"биология\")\n" +
                    "\n" +
                    "-социально - гуманитарный\n" +
                    "(с углубленным изучением предметов \"история\", \"обществознание\", \"литература\")",
            fontFamily = monterrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.DarkGray
        )
    }
}