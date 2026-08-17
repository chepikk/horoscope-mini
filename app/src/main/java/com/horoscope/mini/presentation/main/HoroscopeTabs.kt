package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.horoscope.mini.domain.model.HoroscopeItem

@Composable
fun HoroscopeTabs(viewModel: HoroscopeViewModel = hiltViewModel()) {

    val horoscopes = viewModel.horoscopes.value

    LaunchedEffect(Unit) {
        // Загружаем тестовые данные при первом запуске
        if (horoscopes.isEmpty()) {
            val demoData = listOf(
                HoroscopeItem(sign = "Овен", text = "Сегодня удачный день"),
                HoroscopeItem(sign = "Телец", text = "Время для важных решений"),
                HoroscopeItem(sign = "Близнецы", text = "Ожидаются приятные новости")
            )
            viewModel.loadInitialData(demoData)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(horoscopes) { item ->
            Text(
                text = "${item.sign}: ${item.text}",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}