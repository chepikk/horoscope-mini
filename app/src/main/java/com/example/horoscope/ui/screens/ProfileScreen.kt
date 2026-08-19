package com.example.horoscope.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.horoscope.ui.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    var name by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var zodiacSign by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = birthDate,
            onValueChange = { birthDate = it },
            label = { Text("Дата рождения (ДД.ММ.ГГГГ)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Знак зодиака: $zodiacSign")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.saveUser(name, birthDate)
            zodiacSign = viewModel.getZodiacSign(birthDate)
        }) {
            Text("Сохранить")
        }
    }
}