package com.example.yourlicey28.presentation.profile

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.settings.MemberCard
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.WhiteLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto

val elems = listOf(
    ProfileCardElem("Приём в 1 класс", R.drawable.girl_knowing_best_answer_question),
    ProfileCardElem("Приём в 10 класс", R.drawable.view_school_classroom),
    ProfileCardElem("Фотогаллерея", R.drawable.school28profile)
)

val elemsPopular = listOf(
    ProfileCardElem("Расписание", R.drawable.calendar),
    ProfileCardElem("Кружок28", R.drawable.nti),
    ProfileCardElem("Мои учителя", R.drawable._d_character_132)
)

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    LazyRow(modifier = Modifier
        .padding(top = 20.dp)
        .background(Color.Red)) {
        items(elems){ elem->
//            ProfileCard(elem = elem)
            Text(text = elem.title)
        }
    }

//    Column(
//        modifier = Modifier
//            .background(Color.White)
//            .fillMaxSize()
////            .verticalScroll(rememberScrollState())
//    ) {
//        Text(
//            text = "Профиль",
//            fontSize = 22.sp,
//            fontFamily = monterrat,
//            fontWeight = FontWeight.Bold,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(start = 20.dp, top = 20.dp)
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.owlim),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .height(139.dp)
//                .padding(start = 20.dp, top = 20.dp)
//                .width(117.dp)
//        )
//
//        Text(
//            text = "г. Новосибирск, Лицей №28",
//            fontSize = 16.sp,
//            fontFamily = monterrat,
//            fontWeight = FontWeight.Medium,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(start = 20.dp, top = 20.dp)
//        )
//
//        Text(
//            text = "Сервисы",
//            fontSize = 20.sp,
//            fontFamily = monterrat,
//            fontWeight = FontWeight.Bold,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(start = 20.dp, top = 20.dp)
//        )
//
//
////        Row(
////            modifier = Modifier
////                .padding(top = 20.dp)
////                .horizontalScroll(rememberScrollState())
////        ) {
////            elems.forEach { elem ->
////                ProfileCard(elem = elem)
////            }
////        }
//        Text(
//            text = "Популярные",
//            fontSize = 20.sp,
//            fontFamily = monterrat,
//            fontWeight = FontWeight.Bold,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(start = 20.dp, top = 20.dp)
//        )
//        Row(
//            modifier = Modifier
//                .padding(top = 20.dp)
//                .horizontalScroll(rememberScrollState())
//        ) {
//            elemsPopular.forEach { elem ->
//                ProfileCard(elem = elem)
//            }
//        }
//        Text(
//            text = "Сообщества",
//            fontSize = 20.sp,
//            fontFamily = monterrat,
//            fontWeight = FontWeight.Bold,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(start = 20.dp, top = 20.dp)
//        )
//        Box(modifier = Modifier
//            .padding(top = 15.dp, start = 20.dp)
//            .clip(RoundedCornerShape(20.dp))
//            .background(WhiteLC)
//            .fillMaxWidth(0.95f)
//            .height(60.dp)
//            .clickable {
//
//            }) {
//                Text(
//                    text = "Официальный сайт Лицея №28",
//                    fontSize = 16.sp,
//                    fontFamily = monterrat,
//                    fontWeight = FontWeight.SemiBold,
//                    color = DarkBlueLC,
//                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
//                )
//            }
//        Box(modifier = Modifier
//            .padding(top = 15.dp, start = 20.dp)
//            .clip(RoundedCornerShape(20.dp))
//            .background(WhiteLC)
//            .fillMaxWidth(0.95f)
//            .height(60.dp)
//            .clickable {
//
//            }) {
//            Text(
//                text = "Сообщество Лицея №28",
//                fontSize = 16.sp,
//                fontFamily = monterrat,
//                fontWeight = FontWeight.SemiBold,
//                color = DarkBlueLC,
//                modifier = Modifier.padding(top = 15.dp, start = 10.dp)
//            )
//        }
//
//    }
}

data class ProfileCardElem(
    val title: String,
    @DrawableRes val imageRes: Int
)

@Composable
fun ProfileCard(elem: ProfileCardElem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(125.dp)
            .height(135.dp)
            .clickable {

            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = elem.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(83.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = elem.title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }
    }
}