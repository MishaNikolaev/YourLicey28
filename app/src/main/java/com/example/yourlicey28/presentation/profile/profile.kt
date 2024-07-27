package com.example.yourlicey28.presentation.profile

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.settings.MemberCard
import com.example.yourlicey28.ui.theme.BlueLC
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.WhiteLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto

data class Images(
    @DrawableRes val imageRes: Int,
    val title: String,
)

data class ImagesDown(
    @DrawableRes val imageRes: Int,
    val title: String,
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
        imageRes = R.drawable.uchitel,
        title = "Мои учителя",
    ),
)

val imagesListDown = listOf(
    ImagesDown(
        imageRes = R.drawable.view_school_classroom,
        title = "Приём в 1 класс",
    ),
    ImagesDown(
        imageRes = R.drawable.tenclass,
        title = "Приём в 10 класс",
    ),
    ImagesDown(
        imageRes = R.drawable.school28profile,
        title = "Фотогаллерея",
    ),
)


@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Профиль",
            fontSize = 22.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.owlim),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(139.dp)
                .padding(start = 20.dp, top = 20.dp)
                .width(117.dp)
        )

        Text(
            text = "г. Новосибирск, Лицей №28",
            fontSize = 16.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )

        Text(
            text = "Популярное",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            items(imagesList.size) {
                ImagesItem(it)
            }
        }
        Text(
            text = "Сервисы",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            items(imagesListDown.size) {
                ImagesItemDown(it)
            }
        }
        Text(
            text = "Сообщества",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )
        Box(
            modifier = Modifier
                .padding(top = 15.dp, start = 20.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(WhiteLC)
                .fillMaxWidth(0.95f)
                .height(60.dp)
                .clickable {

                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.licey28),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
            )


            Text(
                text = "Официальный сайт Лицея №28",
                fontSize = 16.sp,
                fontFamily = monterrat,
                fontWeight = FontWeight.Bold,
                color = WhiteLC,
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.CenterStart)
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 15.dp, start = 20.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(WhiteLC)
                .fillMaxWidth(0.95f)
                .height(60.dp)
                .clickable {

                }
        ) {
            Box(
                modifier = Modifier.background(LightBlueLC)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
            )


            Text(
                text = "Сообщество Лицея №28",
                fontSize = 16.sp,
                fontFamily = monterrat,
                fontWeight = FontWeight.Bold,
                color = WhiteLC,
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.CenterStart)
            )
        }
    }
}
@Composable
fun ImagesItem(
    index: Int
) {
    val images = imagesList[index]

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(125.dp)
            .height(125.dp)
            .clickable {
                // Действие при нажатии
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
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
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun ImagesItemDown(
    index: Int
) {
    val imagesDown = imagesListDown[index]

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(125.dp)
            .height(125.dp)
            .clickable {
                // Действие при нажатии
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imagesDown.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(83.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = imagesDown.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

