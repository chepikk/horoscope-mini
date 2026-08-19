package com.example.horoscope.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.horoscope.ui.screens.CompatibilityScreen
import com.example.horoscope.ui.screens.MainHoroscopeScreen
import com.example.horoscope.ui.screens.ProfileScreen
import com.example.horoscope.ui.screens.SearchScreen
import com.example.horoscope.ui.viewmodel.ProfileViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") {
            val viewModel: ProfileViewModel = hiltViewModel()
            ProfileScreen(viewModel = viewModel)
        }
        composable("horoscope") {
            MainHoroscopeScreen()
        }
        composable("compatibility") {
            CompatibilityScreen()
        }
        composable("search") {
            SearchScreen()
        }
    }
}