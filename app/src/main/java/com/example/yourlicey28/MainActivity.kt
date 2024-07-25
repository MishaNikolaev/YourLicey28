package com.example.yourlicey28

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.yourlicey28.presentation.activityComponents.MainScreen
import com.example.yourlicey28.presentation.activityComponents.NavGraphWelcome
import com.example.yourlicey28.presentation.welcome.WelcomeScreenFirst
import com.example.yourlicey28.presentation.welcome.WelcomeScreenSecond
import com.example.yourlicey28.presentation.welcome.WelcomeScreenThird
import com.example.yourlicey28.ui.theme.YourLicey28Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val navController = rememberNavController()

            //NavGraphWelcome(navController = navController)

            MainScreen()
        }
    }
}