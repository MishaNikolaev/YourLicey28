package com.example.yourlicey28.presentation.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavHostController
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.activityComponents.WelcomeRoutes
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.WhiteLC
import com.example.yourlicey28.ui.theme.monterrat
import kotlinx.coroutines.delay

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
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

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
                ImagesItem(it,
                    navController = navController)
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
                ImagesItemDown(it,
                    navController = navController)
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
                modifier = Modifier
                    .background(LightBlueLC)
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
    index: Int,
    navController: NavHostController
) {
    val images = imagesList[index]

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(125.dp)
            .height(125.dp)
            .clickable {
                when(images.title) {
                    "Расписание" -> navController.navigate(WelcomeRoutes.TimeTableScreen.route)
                    "Кружок28" -> navController.navigate(WelcomeRoutes.KruzhokScreen.route)
                    "Мои учителя" -> navController.navigate(WelcomeRoutes.MyTeachersScreen.route)
                    else -> {}
                }
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
    index: Int,
    navController: NavHostController
) {
    val imagesDown = imagesListDown[index]

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(125.dp)
            .height(125.dp)
            .clickable {
                when(imagesDown.title) {
                    "Приём в 1 класс" -> navController.navigate(WelcomeRoutes.EnterToFirstClass.route)
                    "Приём в 10 класс" -> navController.navigate(WelcomeRoutes.EnterToTenClass.route)
                    "Фотогаллерея" -> navController.navigate(WelcomeRoutes.Photogallery.route)
                    else -> {}
                }
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

@Composable
fun ImageCarousel(images: List<Int>, durationMillis: Int) {
    val carouselState = remember { mutableStateOf(0) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        while (true) {
            delay(durationMillis.toLong())
            carouselState.value = (carouselState.value + 1) % images.size
        }
    }

    val imageModifier = Modifier
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

    Box(modifier = Modifier.fillMaxWidth()) {
        images.forEachIndexed { index, imageRes ->
            if (index == carouselState.value) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            }
        }
    }
}

