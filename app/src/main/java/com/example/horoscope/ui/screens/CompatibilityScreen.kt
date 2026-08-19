package com.example.horoscope.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CompatibilityScreen() {
    var sign1 by remember { mutableStateOf("Овен") }
    var sign2 by remember { mutableStateOf("Телец") }
    var result by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Выберите первый знак")
        Text("Выберите второй знак")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            result = "Совместимость $sign1 и $sign2: Хорошая"
        }) {
            Text("Проверить совместимость")
        }

        if (result.isNotEmpty()) {
            Text(result, modifier = Modifier.padding(top = 16.dp))
        }
    }
}