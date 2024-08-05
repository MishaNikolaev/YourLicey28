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
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.RedLC
import com.example.yourlicey28.ui.theme.WhiteLC
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Настройки",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = monterrat,
            color = Color.DarkGray,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )

        Box(modifier = Modifier
            .padding(top = 30.dp, start = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFAFAFA))
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
                    fontFamily = monterrat,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
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
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightBlueLC),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "1.0",
                    fontFamily = monterrat,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Text(
            text = "Это приложение является Open Source продуктом. С удовольствием буду ждать Ваших предложений и сообщений. Буду рад любой помощи/участию в проекте!",
            fontSize = 16.sp,
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
            modifier = Modifier.padding(start = 20.dp)
        )

        ProjectMembersList(members = members)

        Box(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(0.95f)
                .height(64.dp)
                .background(RedLC)
                .clickable {
                    openBottomSheet = true
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Сообщить об ошибке",
                fontSize = 20.sp,
                fontFamily = monterrat,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        FeedbackFormBottomSheet(openBottomSheet) { openBottomSheet = false }
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

@Composable
fun MemberCard(member: ProjectMember) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(member.clickUrl))
                context.startActivity(intent)
            },
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
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
        52,
        "https://github.com/MishaNikolaev"
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackFormBottomSheet(openBottomSheet: Boolean, onDismiss: () -> Unit) {
    var skipPartiallyExpanded by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(skipPartiallyExpanded = skipPartiallyExpanded)

    if (openBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { onDismiss() },
            sheetState = bottomSheetState,
            containerColor = Color.White
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = "Оставить отзыв",
                    fontFamily = roboto,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Кажется, у вас что-то пошло не так. Пожалуйста, напишите нам, и мы постараемся исправить это. Мы свяжемся по указанному email адресу для уточнения деталей.",
                    fontSize = 14.sp,
                    fontFamily = roboto,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Email",
                    fontFamily = roboto,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))

                var email by remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("Введите email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Что случилось?",
                    fontFamily = roboto,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))

                var description by remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    placeholder = { Text("Когда я нажимаю \"X\" происходит \"Y\"") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth(0.95f)
                        .height(44.dp)
                        .background(LightBlueLC)
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Отправить",
                        fontSize = 14.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(70.dp))
            }
        }
    }
}