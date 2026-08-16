package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HoroscopeTabs(viewModel: HoroscopeViewModel = hiltViewModel()) {
    val signs = listOf(
        "Овен", "Телец", "Близнецы", "Рак", "Лев", "Дева",
        "Весы", "Скорпион", "Стрелец", "Козерог", "Водолей", "Рыбы"
    )

    val horoscope by viewModel.horoscope.collectAsState()

    Column {
        TabRow(selectedTabIndex = 0) {
            signs.forEach { sign ->
                Tab(
                    selected = false,
                    onClick = { viewModel.loadHoroscope(sign) },
                    text = { Text(sign) }
                )
            }
        }

        horoscope?.let {
            Text(text = it.text ?: "Гороскоп не найден")
        } ?: Text("Выберите знак зодиака")
    }
}