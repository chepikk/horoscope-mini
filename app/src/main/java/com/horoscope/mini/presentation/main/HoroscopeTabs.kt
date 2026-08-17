package com.horoscope.mini.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.horoscope.mini.presentation.horoscope.HoroscopeViewModel

@Composable
fun HoroscopeTabs(
    navController: NavController,
    viewModel: HoroscopeViewModel = hiltViewModel()
) {
    val horoscopes by viewModel.horoscopes.collectAsState()
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Сегодня", "Неделя", "Месяц")

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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(horoscopes) { item ->
                val text = when (selectedTab) {
                    0 -> item.today
                    1 -> item.week
                    else -> item.month
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Text(
                        text = "${item.sign}\n$text",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            item {
                Button(
                    onClick = { navController.navigate("natal") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                ) {
                    Text("Построить натальную карту")
                }
            }
        }
    }
}