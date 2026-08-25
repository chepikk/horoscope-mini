package com.example.horoscope.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.horoscope.ui.viewmodel.MainHoroscopeViewModel

@Composable
fun MainHoroscopeScreen(
    viewModel: MainHoroscopeViewModel = hiltViewModel()
) {
    val tabs = listOf("Сегодня", "Завтра", "Неделя")
    var selectedTab by remember { mutableStateOf(0) }

    val horoscope by viewModel.horoscope.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { 
                        selectedTab = index
                        viewModel.loadHoroscope(index)
                    },
                    text = { Text(title) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        horoscope?.let {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = it.emoji, style = MaterialTheme.typography.displayMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.text, style = MaterialTheme.typography.bodyLarge)
            }
        } ?: Text(
            text = "Загрузка...",
            modifier = Modifier.padding(16.dp)
        )
    }
}