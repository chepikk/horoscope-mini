package com.horoscope.mini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

data class HoroscopeItem(
    val sign: String,
    val today: String,
    val week: String,
    val month: String
)

class MainActivity : ComponentActivity() {

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val horoscopes = loadHoroscopes()

        setContent {
            MaterialTheme {
                HoroscopeApp(horoscopes)
            }
        }
    }

    private fun loadHoroscopes(): List<HoroscopeItem> {
        return try {
            val inputStream = assets.open("horoscopes.json")
            val reader = InputStreamReader(inputStream)
            val type = object : TypeToken<List<HoroscopeItem>>() {}.type
            gson.fromJson(reader, type)
        } catch (e: Exception) {
            emptyList()
        }
    }
}

@Composable
fun HoroscopeApp(horoscopes: List<HoroscopeItem>) {
    var selectedTab by remember { mutableStateOf(0) }
    var selectedSign by remember { mutableStateOf<HoroscopeItem?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Гороскоп", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Вкладки
        TabRow(selectedTabIndex = selectedTab) {
            Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }, text = { Text("Сегодня") })
            Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }, text = { Text("Неделя") })
            Tab(selected = selectedTab == 2, onClick = { selectedTab = 2 }, text = { Text("Месяц") })
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (selectedSign == null) {
            // Список знаков
            LazyColumn {
                items(horoscopes) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        onClick = { selectedSign = item }
                    ) {
                        Text(
                            text = item.sign,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        } else {
            // Экран выбранного знака
            val sign = selectedSign!!
            val text = when (selectedTab) {
                0 -> sign.today
                1 -> sign.week
                else -> sign.month
            }

            Text(sign.sign, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text, style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { selectedSign = null }) {
                Text("Назад к списку")
            }
        }
    }
}