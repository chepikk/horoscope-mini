package com.example.horoscope.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.horoscope.ui.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { MainHoroscopeScreen() }
        composable("search") { SearchScreen {} }
        composable("compatibility") { CompatibilityScreen() }
        composable("profile") { ProfileScreen() }
    }
}