package com.example.yourlicey28.presentation.settings

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.yourlicey28.R
import com.example.yourlicey28.ui.theme.BlueLC
import com.example.yourlicey28.ui.theme.DarkBlueLC
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.GrayLC
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.LightGreenLC
import com.example.yourlicey28.ui.theme.RedLC
import com.example.yourlicey28.ui.theme.WhiteLC
import com.example.yourlicey28.ui.theme.chooseTheme.ThemeViewModel
import com.example.yourlicey28.ui.theme.monterrat
import com.example.yourlicey28.ui.theme.roboto
import kotlinx.coroutines.launch
@Composable
fun SettingsScreen(
    navController: NavController,
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var showDialogTheme by remember { mutableStateOf(false) }
    val isDarkThemeEnabled by themeViewModel.isDarkThemeEnabled.collectAsState()

    val backgroundColor = if (isDarkThemeEnabled) DarkLC else Color.White
    val textColor = if (isDarkThemeEnabled) Color.White else DarkLC

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Настройки",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = monterrat,
            color = textColor,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )

        Card(
            modifier = Modifier
                .padding(top = 30.dp, start = 20.dp)
                .fillMaxWidth(0.95f)
                .height(60.dp)
                .clickable { showDialogTheme = true },
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(backgroundColor),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Palette,
                    contentDescription = "Theme Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(36.dp)
                        .padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))

                Text(
                    text = "Тема",
                    fontSize = 16.sp,
                    fontFamily = monterrat,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 10.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Arrow Icon",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 10.dp)
                )
            }
        }

        if (showDialogTheme) {
            AlertDialog(
                onDismissRequest = { showDialogTheme = false },
                title = {
                    Text(text = "Выбор темы", color = textColor, fontFamily = roboto)
                },
                text = {
                    ThemeSelectionBox { theme ->
                        when (theme) {
                            "Тёмная" -> themeViewModel.setDarkThemeEnabled(true)
                            "Светлая" -> themeViewModel.setDarkThemeEnabled(false)
                        }
                        showDialogTheme = false
                    }
                },
                confirmButton = { TextButton(onClick = { showDialogTheme = false }) { Text("Закрыть") } },
                dismissButton = {},
                containerColor = backgroundColor
            )
        }
    }
}
