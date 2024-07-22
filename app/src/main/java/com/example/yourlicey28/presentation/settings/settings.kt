package com.example.yourlicey28.presentation.settings

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.RedLC
import com.example.yourlicey28.ui.theme.WhiteLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto

@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Настройки",
            fontSize = 22.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )

        Box(modifier = Modifier
            .padding(top = 30.dp, start = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(WhiteLC)
            .fillMaxWidth(0.95f)
            .height(60.dp)
            .clickable {

            }) {
            Row {
                Icon(
                    imageVector = Icons.Default.Palette,
                    contentDescription = "Add Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(36.dp)
                        .padding(top = 10.dp, start = 10.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))

                Text(
                    text = "Тема",
                    fontSize = 16.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlueLC,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Spacer(modifier = Modifier.width(150.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Add Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(20.dp)
                )
            }
        }

        Box(modifier = Modifier
            .padding(top = 15.dp, start = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(WhiteLC)
            .fillMaxWidth(0.95f)
            .height(60.dp)
            .clickable {

            }) {
            Row {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Add Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(36.dp)
                        .padding(top = 10.dp, start = 10.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))

                Text(
                    text = "Уведомления",
                    fontSize = 16.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlueLC,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Spacer(modifier = Modifier.width(85.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Add Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(20.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Open Source",
                fontSize = 25.sp,
                fontFamily = monterrat,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(start = 20.dp, end = 10.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(50.dp))

            Box(
                modifier = Modifier
                    .size(35.dp)
                    .background(LightBlueLC),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "1.0",
                    fontSize = 16.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.SemiBold,
                    color = WhiteLC,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Text(
            text = "Это приложение является Open Source продуктом. С удовольствием буду ждать Ваших предложений и сообщений. Буду рад любой помощи/участию в проекте!",
            fontSize = 16.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            modifier = Modifier.padding(start = 20.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.github),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(59.dp)
                    .width(57.dp)
                    .clickable {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/MishaNikolaev/YourLicey28")
                        )
                        context.startActivity(intent)
                    }
            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.telegrampng),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(59.dp)
                    .width(55.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/yumih1"))
                        context.startActivity(intent)
                    }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Участники проекта",
            fontSize = 20.sp,
            fontFamily = monterrat,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 20.dp)
        )

        ProjectMembersList(members = members)


        Box(
            modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(0.95f)
                .height(64.dp)
                .background(RedLC).clickable {

                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Сообщить об ошибке",
                fontSize = 20.sp,
                fontFamily = monterrat,
                fontWeight = FontWeight.Bold,
                color = WhiteLC,
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}

data class ProjectMember(
    val imageUrl: String,
    val name: String,
    val commitCount: Int,
    val clickUrl: String
)

val members = listOf(
    ProjectMember(
        "https://avatars.githubusercontent.com/u/111734592?s=400&u=a54918d28c1e4037ad6a610c66b0424b1bb3a90f&v=4",
        "Mikhail Nikolaev",
        22,
        "https://github.com/MishaNikolaev"
    ),
)

@Composable
fun MemberCard(member: ProjectMember) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(member.clickUrl))
            context.startActivity(intent)
        },
        colors = CardDefaults.cardColors(
            containerColor = WhiteLC
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = member.imageUrl),
                contentDescription = "Member Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(member.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("${member.commitCount} коммита", fontSize = 14.sp)
            }
        }
    }
}


@Composable
fun ProjectMembersList(members: List<ProjectMember>) {
    LazyRow(
        modifier = Modifier.padding(16.dp)
    ) {
        items(members) { member ->
            MemberCard(member)
        }
    }
}