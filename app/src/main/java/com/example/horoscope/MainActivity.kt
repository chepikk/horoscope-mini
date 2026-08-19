package com.example.horoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.horoscope.ui.screens.MainHoroscopeScreen
import com.example.horoscope.ui.screens.ProfileScreen
import com.example.horoscope.ui.theme.HoroscopeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoroscopeTheme {
                HoroscopeApp()
            }
        }
    }
}

@Composable
fun HoroscopeApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "profile"
    ) {
        composable("profile") {
            ProfileScreen(
                viewModel = hiltViewModel(),
                onNavigateToMain = {
                    navController.navigate("main") {
                        popUpTo("profile") { inclusive = true }
                    }
                }
            )
        }

        composable("main") {
            MainHoroscopeScreen(
                viewModel = hiltViewModel()
            )
        }
    }
}