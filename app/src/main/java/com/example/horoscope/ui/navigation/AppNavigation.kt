package com.example.horoscope.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.horoscope.ui.screens.*

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "profile"
    ) {
        composable("profile") {
            ProfileScreen(viewModel = hiltViewModel())
        }
        composable("horoscope") {
            MainHoroscopeScreen()
        }
        composable("search") {
            SearchScreen(onSignSelected = { sign ->
                // Пока просто переходим на гороскоп
                navController.navigate("horoscope")
            })
        }
        composable("compatibility") {
            CompatibilityScreen()
        }
    }
}