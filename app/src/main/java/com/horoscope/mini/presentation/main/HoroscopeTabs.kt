package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun HoroscopeTabs(
    viewModel: HoroscopeViewModel,
    modifier: Modifier = Modifier
) {
    val signs = listOf("Овен", "Телец", "Близнецы", "Рак", "Лев", "Дева",
        "Весы", "Скорпион", "Стрелец", "Козерог", "Водолей", "Рыбы")
    var selectedTab by remember { mutableStateOf(0) }

    val horoscope by viewModel.horoscope.collectAsState()

    Column(modifier = modifier) {
        TabRow(selectedTabIndex = selectedTab) {
            signs.forEachIndexed { index, sign ->
                Tab(
                    selected = selectedTab == index,
                    onClick = {
                        selectedTab = index
                        viewModel.loadHoroscope(sign)
                    },
                    text = { Text(sign) }
                )
            }
        }

        horoscope?.let {
            Text(text = it.text)
        } ?: Text(text = "Выберите знак зодиака")
    }
}