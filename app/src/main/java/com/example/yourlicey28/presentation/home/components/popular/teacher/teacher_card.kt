package com.example.yourlicey28.presentation.home.components.popular.teacher

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourlicey28.domain.model.Teacher
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto
@Composable
fun TeacherCard(teacher: Teacher) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .height(150.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 5.dp),
                text = teacher.name,
                fontFamily = monterrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Row {
                Column(modifier = Modifier.weight(2f)) {
                    Text(
                        modifier = Modifier
                            .padding(top = 5.dp),
                        text = teacher.info,
                        fontFamily = roboto,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 9.sp,
                        color = Color.DarkGray
                    )
                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = teacher.email,
                        fontFamily = roboto,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 9.sp,
                        color = LightBlueLC
                        //color = Color(0xFFFFAB26)
                    )
                }
                Image(
                    painter = painterResource(id = teacher.id),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .weight(1f)
                )
            }
        }
    }
}