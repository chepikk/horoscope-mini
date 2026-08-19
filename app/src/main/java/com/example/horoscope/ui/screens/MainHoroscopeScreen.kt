package com.example.horoscope.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainHoroscopeScreen() {
    val tabs = listOf("Сегодня", "Завтра", "Неделя")
    var selectedTab by remember { mutableStateOf(0) }

    Column {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        when (selectedTab) {
            0 -> HoroscopeContent(period = "today")
            1 -> HoroscopeContent(period = "tomorrow")
            2 -> HoroscopeContent(period = "week")
        }
    }
}

@Composable
fun HoroscopeContent(period: String) {
    Text(
        text = "Гороскоп на $period",
        modifier = Modifier.padding(16.dp)
    )
}