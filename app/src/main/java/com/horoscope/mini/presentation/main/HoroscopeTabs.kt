package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HoroscopeTabs(viewModel: HoroscopeViewModel) {
    val horoscopes = viewModel.horoscopes.collectAsState().value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (horoscopes.isEmpty()) {
            Text("Загрузка гороскопов...")
        } else {
            Text("Гороскопы загружены: ${horoscopes.size} знаков")
        }
    }
}