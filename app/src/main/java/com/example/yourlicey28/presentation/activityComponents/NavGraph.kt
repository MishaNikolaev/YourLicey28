package com.example.yourlicey28.presentation.activityComponents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.news.NewsScreen
import com.example.yourlicey28.presentation.news.NewsViewModel
import com.example.yourlicey28.presentation.profile.ProfileScreen
import com.example.yourlicey28.presentation.settings.SettingsScreen
import com.example.yourlicey28.presentation.welcome.WelcomeScreenFirst
import com.example.yourlicey28.presentation.welcome.WelcomeScreenSecond
import com.example.yourlicey28.presentation.welcome.WelcomeScreenThird
import com.example.yourlicey28.presentation.welcome.WelcomeViewModel
import com.example.yourlicey28.ui.theme.BlueLC
import com.example.yourlicey28.ui.theme.GrayLC
import com.example.yourlicey28.ui.theme.LightBlueLC

sealed class WelcomeRoutes(val route: String) {
    object WelcomeScreenFirst : WelcomeRoutes("welcome_screen_first")
    object WelcomeScreenSecond : WelcomeRoutes("welcome_screen_second")
    object WelcomeScreenThird : WelcomeRoutes("welcome_screen_third")
    object NewsScreen : WelcomeRoutes("news_screen")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavGraphWelcome(
    navController: NavHostController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    if (viewModel.state.finished) {
        NavHost(
            navController = navController,
            startDestination = if(viewModel.state.isInitial != -1){
                WelcomeRoutes.NewsScreen.route
            } else{
                WelcomeRoutes.WelcomeScreenFirst.route
            }
        ) {

            composable(WelcomeRoutes.WelcomeScreenFirst.route) {
                WelcomeScreenFirst(navController = navController)
            }

            composable(WelcomeRoutes.WelcomeScreenSecond.route) {
                WelcomeScreenSecond(navController = navController)
            }

            composable(WelcomeRoutes.WelcomeScreenThird.route) {
                WelcomeScreenThird(navController = navController)
            }

            composable(WelcomeRoutes.NewsScreen.route) {
                //val viewModel:NewsViewModel = hiltViewModel()
                NewsScreen()
            }
        }
    }
}
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: WelcomeViewModel = hiltViewModel()

    if (viewModel.state.finished) {
        if (viewModel.state.isInitial != -1) {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) { innerPadding ->
                NavigationGraph(navController = navController, modifier = Modifier.padding(innerPadding))
            }
        } else {
            NavGraphWelcome(navController = navController, viewModel = viewModel)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.News,
        BottomNavItem.Profile,
        BottomNavItem.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(containerColor = Color.White) {
        items.forEach { item ->
            val isActive = currentRoute == item.route
            val iconResId = if (isActive) item.activeIcon else item.icon

            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = iconResId),
                        contentDescription = item.title,
                        modifier = Modifier.size(28.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (isActive) LightBlueLC else GrayLC
                    )
                },
                selected = false,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(val route: String, val icon: Int, val activeIcon: Int, val title: String) {
    object News : BottomNavItem("news", R.drawable.newsic_no, R.drawable.newsic, "Новости")
    object Profile : BottomNavItem("profile", R.drawable.profileic_no, R.drawable.profileic, "Профиль")
    object Settings : BottomNavItem("settings", R.drawable.settings_no, R.drawable.settings, "Настройки")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.News.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.News.route) {
            NewsScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen(navController)
        }
        composable(BottomNavItem.Settings.route) {
//            val viewModel:HomeViewModel = hiltViewModel()
            SettingsScreen(navController)
        }
    }
}