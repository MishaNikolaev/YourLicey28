package com.example.yourlicey28.presentation.activityComponents

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.R
import com.example.yourlicey28.presentation.news.NewsScreen
import com.example.yourlicey28.presentation.home.HomeScreen
import com.example.yourlicey28.presentation.home.components.popular.KruzhokScreen
import com.example.yourlicey28.presentation.home.components.popular.teacher.MyTeachersScreen
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.ChooseTimeTable
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.TimeTableScreen
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.first.First_A_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.first.First_G_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.first.First_V_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.first.First_b_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.first.First_d_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.fourth.Fourth_A_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.fourth.Fourth_B_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.fourth.Fourth_G_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.fourth.Fourth_V_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.second.Second_A_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.second.Second_b_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.second.Second_g_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.second.Second_v_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.third.Third_A_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.third.Third_G_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.third.Third_V_Class
import com.example.yourlicey28.presentation.home.components.popular.timetable_components.time_table_classes.third.Third_b_Class
import com.example.yourlicey28.presentation.home.components.services.AboutSchool
import com.example.yourlicey28.presentation.home.components.services.EnterToFirstClass
import com.example.yourlicey28.presentation.home.components.services.EnterToTenClass
import com.example.yourlicey28.presentation.news.NewsViewModel
import com.example.yourlicey28.presentation.settings.SettingsScreen
import com.example.yourlicey28.presentation.welcome.WelcomeScreenFirst
import com.example.yourlicey28.presentation.welcome.WelcomeScreenSecond
import com.example.yourlicey28.presentation.welcome.WelcomeScreenThird
import com.example.yourlicey28.presentation.welcome.WelcomeViewModel
import com.example.yourlicey28.ui.theme.GrayLC
import com.example.yourlicey28.ui.theme.LightBlueLC

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

    //First classes time table
    object FirstAClass : WelcomeRoutes("first_a_class")
    object FirstBClass : WelcomeRoutes("first_b_class")
    object FirstVClass : WelcomeRoutes("first_v_class")
    object FirstGClass : WelcomeRoutes("first_g_class")
    object FirstDClass : WelcomeRoutes("first_d_class")

    //Second classes time table
    object SecondAClass : WelcomeRoutes("second_a_class")
    object SecondBClass : WelcomeRoutes("second_b_class")
    object SecondVClass : WelcomeRoutes("second_v_class")
    object SecondtGClass : WelcomeRoutes("second_g_class")

    //Third classes time table
    object ThirdAClass : WelcomeRoutes("third_a_class")
    object ThirdBClass : WelcomeRoutes("third_b_class")
    object ThirdVClass : WelcomeRoutes("third_v_class")
    object ThirdGClass : WelcomeRoutes("third_g_class")

    //Fourth classes time table
    object ForthAClass : WelcomeRoutes("forth_a_class")
    object ForthBClass : WelcomeRoutes("forth_b_class")
    object ForthVClass : WelcomeRoutes("forth_v_class")
    object ForthGClass : WelcomeRoutes("forth_g_class")
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavGraphWelcome(
    navController: NavHostController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    if (viewModel.state.finished) {
        NavHost(
            navController = navController,
            startDestination = if (viewModel.state.isInitial != -1) {
                WelcomeRoutes.NewsScreen.route
            } else {
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
                Scaffold(
                    bottomBar = { BottomNavigationBar(rememberNavController()) }
                ) { innerPadding ->
                    NavigationGraph(
                        navController = rememberNavController(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            composable(WelcomeRoutes.KruzhokScreen.route) {
                KruzhokScreen(navController = navController)
            }
            composable(WelcomeRoutes.TimeTableScreen.route) {
                TimeTableScreen(navController = navController)
            }

            composable(WelcomeRoutes.MyTeachersScreen.route) {
                MyTeachersScreen(navController = navController)
            }

            composable(WelcomeRoutes.EnterToFirstClass.route) {
                EnterToFirstClass(navController = navController)
            }

            composable(WelcomeRoutes.EnterToTenClass.route) {
                EnterToTenClass(navController = navController)
            }

            composable(WelcomeRoutes.AboutSchool.route) {
                AboutSchool(navController = navController)
            }

            composable(WelcomeRoutes.HomeScreen.route) {
                HomeScreen(navController)
            }

            composable(WelcomeRoutes.ChooseTimeTable.route) {
                ChooseTimeTable(navController)
            }

            //First classes time table
            composable(WelcomeRoutes.FirstAClass.route) {
                First_A_Class(navController = navController)
            }
            composable(WelcomeRoutes.FirstBClass.route) {
                First_b_Class(navController = navController)
            }
            composable(WelcomeRoutes.FirstVClass.route) {
                First_V_Class(navController = navController)
            }
            composable(WelcomeRoutes.FirstGClass.route) {
                First_G_Class(navController = navController)
            }
            composable(WelcomeRoutes.FirstDClass.route) {
                First_d_Class(navController = navController)
            }

            //Second classes time table
            composable(WelcomeRoutes.SecondAClass.route) {
                Second_A_Class(navController = navController)
            }
            composable(WelcomeRoutes.SecondBClass.route) {
                Second_b_Class(navController = navController)
            }
            composable(WelcomeRoutes.SecondVClass.route) {
                Second_v_Class(navController = navController)
            }
            composable(WelcomeRoutes.SecondtGClass.route) {
                Second_g_Class(navController = navController)
            }

            //Third classes time table
            composable(WelcomeRoutes.ThirdAClass.route) {
                Third_A_Class(navController = navController)
            }
            composable(WelcomeRoutes.ThirdBClass.route) {
                Third_b_Class(navController = navController)
            }
            composable(WelcomeRoutes.ThirdVClass.route) {
                Third_V_Class(navController = navController)
            }
            composable(WelcomeRoutes.ThirdGClass.route) {
                Third_G_Class(navController = navController)
            }

            //Fourth classes time table
            composable(WelcomeRoutes.ForthAClass.route) {
                Fourth_A_Class(navController = navController)
            }
            composable(WelcomeRoutes.ForthBClass.route) {
                Fourth_B_Class(navController = navController)
            }
            composable(WelcomeRoutes.ForthVClass.route) {
                Fourth_V_Class(navController = navController)
            }
            composable(WelcomeRoutes.ForthGClass.route) {
                Fourth_G_Class(navController = navController)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: WelcomeViewModel = hiltViewModel()

    if (viewModel.state.finished) {
        if (viewModel.state.isInitial != -1) {
            Scaffold(
                bottomBar = { BottomNavigationBar(navController) }
            ) { innerPadding ->
                NavigationGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        } else {
            NavGraphWelcome(navController = navController, viewModel = viewModel)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.News,
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
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
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
            NewsScreen(
                viewModel = viewModel,
                onLikeClicked = { news ->
                    viewModel.onLickeClicked(news = news)
                }
            )
        }
        composable(BottomNavItem.Settings.route) {
//            val viewModel:HomeViewModel = hiltViewModel()
            SettingsScreen(navController)
        }
        composable(WelcomeRoutes.KruzhokScreen.route) {
            KruzhokScreen(navController = navController)
        }
        composable(WelcomeRoutes.TimeTableScreen.route) {
            TimeTableScreen(navController = navController)
        }

        composable(WelcomeRoutes.MyTeachersScreen.route) {
            MyTeachersScreen(navController = navController)
        }

        composable(WelcomeRoutes.EnterToFirstClass.route) {
            EnterToFirstClass(navController = navController)
        }

        composable(WelcomeRoutes.EnterToTenClass.route) {
            EnterToTenClass(navController = navController)
        }

        composable(WelcomeRoutes.AboutSchool.route) {
            AboutSchool(navController = navController)
        }
        composable(WelcomeRoutes.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(WelcomeRoutes.ChooseTimeTable.route) {
            ChooseTimeTable(navController)
        }
        //First classes time table
        composable(WelcomeRoutes.FirstAClass.route) {
            First_A_Class(navController = navController)
        }
        composable(WelcomeRoutes.FirstBClass.route) {
            First_b_Class(navController = navController)
        }
        composable(WelcomeRoutes.FirstVClass.route) {
            First_V_Class(navController = navController)
        }
        composable(WelcomeRoutes.FirstGClass.route) {
            First_G_Class(navController = navController)
        }
        composable(WelcomeRoutes.FirstDClass.route) {
            First_d_Class(navController = navController)
        }

        //Second classes time table
        composable(WelcomeRoutes.SecondAClass.route) {
            Second_A_Class(navController = navController)
        }
        composable(WelcomeRoutes.SecondBClass.route) {
            Second_b_Class(navController = navController)
        }
        composable(WelcomeRoutes.SecondVClass.route) {
            Second_v_Class(navController = navController)
        }
        composable(WelcomeRoutes.SecondtGClass.route) {
            Second_g_Class(navController = navController)
        }

        //Third classes time table
        composable(WelcomeRoutes.ThirdAClass.route) {
            Third_A_Class(navController = navController)
        }
        composable(WelcomeRoutes.ThirdBClass.route) {
            Third_b_Class(navController = navController)
        }
        composable(WelcomeRoutes.ThirdVClass.route) {
            Third_V_Class(navController = navController)
        }
        composable(WelcomeRoutes.ThirdGClass.route) {
            Third_G_Class(navController = navController)
        }

        //Fourth classes time table
        composable(WelcomeRoutes.ForthAClass.route) {
            Fourth_A_Class(navController = navController)
        }
        composable(WelcomeRoutes.ForthBClass.route) {
            Fourth_B_Class(navController = navController)
        }
        composable(WelcomeRoutes.ForthVClass.route) {
            Fourth_V_Class(navController = navController)
        }
        composable(WelcomeRoutes.ForthGClass.route) {
            Fourth_G_Class(navController = navController)
        }
    }
}