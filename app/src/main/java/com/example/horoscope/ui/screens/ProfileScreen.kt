package com.example.horoscope.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.horoscope.data.local.User
import com.example.horoscope.ui.viewmodel.ProfileViewModel
import com.example.horoscope.utils.ZodiacUtils

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onNavigateToMain: () -> Unit = {}
) {
    val currentUser by viewModel.user.collectAsState()

    var name by remember { mutableStateOf(currentUser?.name ?: "") }
    var birthDate by remember { mutableStateOf(currentUser?.birthDate ?: "") }

    LaunchedEffect(currentUser) {
        currentUser?.let {
            name = it.name
            birthDate = it.birthDate
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Профиль", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = birthDate,
            onValueChange = { birthDate = it },
            label = { Text("Дата рождения (дд.мм.гггг)") },
            modifier = Modifier.fillMaxWidth()
        )

        val zodiac = if (birthDate.isNotBlank()) ZodiacUtils.getZodiacSign(birthDate) else "—"
        Text("Знак зодиака: $zodiac")

        Button(
            onClick = {
                if (name.isNotBlank() && birthDate.isNotBlank()) {
                    val user = User(
                        name = name,
                        birthDate = birthDate,
                        zodiacSign = zodiac
                    )
                    viewModel.saveUser(user)
                    onNavigateToMain()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить профиль")
        }
    }
}