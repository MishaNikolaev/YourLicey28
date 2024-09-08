package com.example.yourlicey28.presentation.activityComponents

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.news.NewsScreen
import com.example.yourlicey28.presentation.home.HomeScreen
import com.example.yourlicey28.presentation.home.components.popular.KruzhokScreen
import com.example.yourlicey28.presentation.home.components.popular.teacher.MyTeachersScreen
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.ChooseTimeTable
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.TimeTableScreen
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.ScheduleScreen
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.ScheduleViewModel
import com.example.yourlicey28.presentation.home.components.services.AboutSchool
import com.example.yourlicey28.presentation.home.components.services.EnterToFirstClass
import com.example.yourlicey28.presentation.home.components.services.EnterToTenClass
import com.example.yourlicey28.presentation.news.NewsViewModel
import com.example.yourlicey28.presentation.news.certain_news.NewsViewModelDetails
import com.example.yourlicey28.presentation.news.certain_news.Screen
import com.example.yourlicey28.presentation.settings.SettingsScreen
import com.example.yourlicey28.presentation.welcome.WelcomeViewModel
import com.example.yourlicey28.ui.theme.DarkLC
import com.example.yourlicey28.ui.theme.GrayLC
import com.example.yourlicey28.ui.theme.LightBlueLC
import com.example.yourlicey28.ui.theme.chooseTheme.ThemeViewModel

private const val TAG = "NavGraph"

sealed class WelcomeRoutes(val route: String) {
    object WelcomeScreenFirst : WelcomeRoutes("welcome_screen_first")
    object WelcomeScreenSecond : WelcomeRoutes("welcome_screen_second")
    object WelcomeScreenThird : WelcomeRoutes("welcome_screen_third")
    object NewsScreen : WelcomeRoutes("news_screen")
    object HomeScreen : WelcomeRoutes("home_screen")
    object KruzhokScreen : WelcomeRoutes("kruzhok_screen")
    object TimeTableScreen : WelcomeRoutes("time_table_screen")
    object MyTeachersScreen : WelcomeRoutes("my_teachers_screen")
    object EnterToFirstClass : WelcomeRoutes("enter_to_first_class")
    object EnterToTenClass : WelcomeRoutes("enter_to_ten_class")
    object AboutSchool : WelcomeRoutes("about_school")
    object ChooseTimeTable : WelcomeRoutes("choose_time_table")
    object ScreenNews : WelcomeRoutes("screen_news")
    object ScheduleScreen : WelcomeRoutes("schedule_screen")


}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: WelcomeViewModel,
    themeViewModel: ThemeViewModel = hiltViewModel(),
    isDarkThemeEnabled: Boolean
) {
    val mainNavController = rememberNavController()

    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = currentRoute in listOf(
        BottomNavItem.Home.route,
        BottomNavItem.News.route,
        BottomNavItem.Settings.route
    )

    Scaffold(
        bottomBar = { if (showBottomBar) BottomNavigationBar(mainNavController, themeViewModel) }
    ) { innerPadding ->
        NavigationGraph(
            navController = mainNavController,
            modifier = Modifier.padding(innerPadding),
            isDarkThemeEnabled = isDarkThemeEnabled
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController, themeViewModel: ThemeViewModel) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.News,
        BottomNavItem.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isDarkThemeEnabled by themeViewModel.isDarkThemeEnabled.collectAsState()

    val backgroundColor = if (isDarkThemeEnabled) DarkLC else Color.White
    val activeColor = LightBlueLC  // Используем один и тот же цвет для активного состояния
    val inactiveColor = if (isDarkThemeEnabled) Color.Gray else GrayLC

    NavigationBar(containerColor = backgroundColor) {
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
                        color = if (isActive) activeColor else inactiveColor
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
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = activeColor,
                    unselectedIconColor = inactiveColor,
                    selectedTextColor = activeColor,
                    unselectedTextColor = inactiveColor
                )
            )
        }
    }
}

sealed class BottomNavItem(
    val route: String,
    val icon: Int,
    val activeIcon: Int,
    val title: String
) {
    object Home : BottomNavItem("home", R.drawable.homeno, R.drawable.home_2, "Главная")
    object News : BottomNavItem("news", R.drawable.newsic_no, R.drawable.newsic, "Новости")
    object Settings :
        BottomNavItem("settings", R.drawable.settings_no, R.drawable.settings, "Настройки")
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController, modifier: Modifier = Modifier,
    isDarkThemeEnabled: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.News.route) {
            val viewModel: NewsViewModel = hiltViewModel()
            val news = viewModel.newsPagingFlow.collectAsLazyPagingItems()
            NewsScreen(
                state = viewModel.state,
                news = news,
                onLikeClicked = { news ->
                    viewModel.onLickeClicked(news = news)
                },
                onImportantClicked = { news ->
                    viewModel.onImportantClicked(news = news)
                },
                onCardClicked = { id ->
                    navController.navigate(WelcomeRoutes.ScreenNews.route + "?id=${id}")
                }
            )
        }
        composable(BottomNavItem.Settings.route) {
// val viewModel:HomeViewModel = hiltViewModel()
            SettingsScreen(navController)
        }

        composable(WelcomeRoutes.KruzhokScreen.route) {
            KruzhokScreen(navController = navController, isDarkThemeEnabled)
        }
        composable(
            route = WelcomeRoutes.ScreenNews.route + "?id={id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = -1  // Можно задать значение по умолчанию при необходимости
                }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("id") ?: -1
            val viewModel: NewsViewModelDetails = hiltViewModel()
            val themeViewModel: ThemeViewModel = hiltViewModel()

            Screen(
                viewModel = viewModel,
                themeViewModel = themeViewModel,
                state = viewModel.state.value,
                processEvent = viewModel::processEvent
            )
        }
        composable(WelcomeRoutes.TimeTableScreen.route) {
            TimeTableScreen(navController = navController, isDarkThemeEnabled)
        }

        composable(WelcomeRoutes.MyTeachersScreen.route) {
            MyTeachersScreen(
                navController = navController,
                isDarkThemeEnabled = isDarkThemeEnabled
            )
        }

        composable(WelcomeRoutes.EnterToFirstClass.route) {
            EnterToFirstClass(navController = navController, isDarkThemeEnabled)
        }

        composable(WelcomeRoutes.EnterToTenClass.route) {
            EnterToTenClass(navController = navController, isDarkThemeEnabled)
        }

        composable(WelcomeRoutes.AboutSchool.route) {
            AboutSchool(navController = navController, isDarkThemeEnabled)
        }
        composable(WelcomeRoutes.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(WelcomeRoutes.ChooseTimeTable.route) {
            ChooseTimeTable(navController, isDarkThemeEnabled)
        }
        composable(
            route = WelcomeRoutes.ScheduleScreen.route + "?schedule={schedule}",
            arguments = listOf(
                navArgument("schedule") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val schedule = navBackStackEntry.arguments?.getString("schedule") ?: ""
            val viewModel: ScheduleViewModel = hiltViewModel()
            val themeViewModel: ThemeViewModel = hiltViewModel()

            ScheduleScreen(
                navController = navController,
                viewModel = viewModel,
                state = viewModel.state.value,
            )
        }
    }
}