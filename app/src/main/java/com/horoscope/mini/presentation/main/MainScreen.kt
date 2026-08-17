package com.horoscope.mini.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.horoscope.mini.presentation.natal.NatalChartScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            HoroscopeTabs(navController = navController)
        }
        composable("natal") {
            NatalChartScreen(onBack = { navController.popBackStack() })
        }
    }
}