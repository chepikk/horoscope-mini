package com.example.horoscope.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.horoscope.data.local.User
import com.example.horoscope.ui.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {
    val user by viewModel.user.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Профиль",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = user.name,
            onValueChange = { newName ->
                viewModel.updateUser(user.copy(name = newName))
            },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = user.birthDate,
            onValueChange = { newDate ->
                viewModel.updateUser(user.copy(birthDate = newDate))
            },
            label = { Text("Дата рождения (дд.мм.гггг)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Знак зодиака: ${user.zodiacSign}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Здесь можно добавить логику сохранения в Room позже
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить профиль")
        }
    }
}