package com.example.yourlicey28.presentation.activityComponents

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.presentation.news.NewsScreen
import com.example.yourlicey28.presentation.welcome.WelcomeScreenFirst
import com.example.yourlicey28.presentation.welcome.WelcomeScreenSecond
import com.example.yourlicey28.presentation.welcome.WelcomeScreenThird
import com.example.yourlicey28.presentation.welcome.WelcomeViewModel

sealed class WelcomeRoutes(val route: String) {
    object WelcomeScreenFirst : WelcomeRoutes("welcome_screen_first")
    object WelcomeScreenSecond : WelcomeRoutes("welcome_screen_second")
    object WelcomeScreenThird : WelcomeRoutes("welcome_screen_third")
    object NewsScreen : WelcomeRoutes("news_screen")
}

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
                NewsScreen(navController = navController)
            }
        }
    }
}