package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    val viewModel: HoroscopeViewModel = hiltViewModel()

    Scaffold { padding ->
        HoroscopeTabs(
            viewModel = viewModel,
            modifier = Modifier.padding(padding)
        )
    }
}