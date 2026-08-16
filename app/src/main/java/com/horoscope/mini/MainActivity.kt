package com.horoscope.mini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

data class Horoscope(
    val sign: String,
    val today: String,
    val week: String,
    val month: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val horoscopes = loadHoroscopes()

        setContent {
            MaterialTheme {
                HoroscopeScreen(horoscopes)
            }
        }
    }

    private fun loadHoroscopes(): List<Horoscope> {
        val inputStream = assets.open("horoscopes.json")
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Horoscope>>() {}.type
        return Gson().fromJson(reader, type)
    }
}

@Composable
fun HoroscopeScreen(horoscopes: List<Horoscope>) {
    var selectedSign by remember { mutableStateOf(horoscopes.first()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Выбери знак зодиака", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        horoscopes.forEach { horoscope ->
            Button(
                onClick = { selectedSign = horoscope },
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text(horoscope.sign)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Сегодня: ${selectedSign.today}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Неделя: ${selectedSign.week}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Месяц: ${selectedSign.month}", style = MaterialTheme.typography.bodyLarge)
    }
}