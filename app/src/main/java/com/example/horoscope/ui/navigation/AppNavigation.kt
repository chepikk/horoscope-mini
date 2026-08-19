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
            MainHoroscopeScreen(viewModel = hiltViewModel())
        }
        composable("search") {
            SearchScreen(viewModel = hiltViewModel())
        }
        composable("compatibility") {
            CompatibilityScreen(
                viewModel = hiltViewModel(),
                onSignSelected = { /* позже */ }
            )
        }
    }
}