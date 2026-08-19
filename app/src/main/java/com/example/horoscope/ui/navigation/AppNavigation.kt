package com.example.horoscope.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.horoscope.ui.screens.MainHoroscopeScreen
import com.example.horoscope.ui.screens.ProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "profile"
    ) {
        composable("profile") {
            ProfileScreen(
                viewModel = hiltViewModel(),
                onNavigateToMain = { navController.navigate("main") }
            )
        }
        composable("main") {
            MainHoroscopeScreen()
        }
    }
}