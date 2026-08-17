package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HoroscopeTabs(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Сегодня", "Завтра", "Неделя")

    Column(modifier = modifier) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> Text("Гороскоп на сегодня")
            1 -> Text("Гороскоп на завтра")
            2 -> Text("Гороскоп на неделю")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("natal") }) {
            Text("Натальная карта")
        }
    }
}