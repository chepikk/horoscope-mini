package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.horoscope.mini.presentation.natal.NatalChartScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold { padding ->
        NavHost(
            navController = navController,
            startDestination = "horoscope",
            modifier = Modifier.padding(padding)
        ) {
            composable("horoscope") {
                HoroscopeTabs(viewModel = hiltViewModel())
            }
            composable("natal") {
                NatalChartScreen()
            }
        }
    }
}