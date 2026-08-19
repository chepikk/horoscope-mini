package com.example.horoscope.ui.navigation

import androidx.compose.runtime.Composable
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
            ProfileScreen()
        }
        composable("horoscope") {
            MainHoroscopeScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("compatibility") {
            CompatibilityScreen(
                onSignSelected = { /* пока пусто, позже добавим */ }
            )
        }
    }
}