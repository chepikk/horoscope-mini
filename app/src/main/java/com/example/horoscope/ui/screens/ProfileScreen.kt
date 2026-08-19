package com.example.horoscope.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.horoscope.ui.viewmodel.ProfileViewModel
import com.example.horoscope.utils.ZodiacUtils

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onNavigateToMain: () -> Unit
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
            value = user?.name ?: "",
            onValueChange = { newName ->
                user?.let { viewModel.updateUser(it.copy(name = newName)) }
            },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = user?.birthDate ?: "",
            onValueChange = { newDate ->
                user?.let { viewModel.updateUser(it.copy(birthDate = newDate)) }
            },
            label = { Text("Дата рождения (дд.мм.гггг)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Знак зодиака: ${user?.zodiacSign?.ifEmpty { "—" } ?: "—"}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                user?.let { currentUser ->
                    val zodiac = ZodiacUtils.getZodiacSign(currentUser.birthDate)
                    val updatedUser = currentUser.copy(zodiacSign = zodiac)
                    viewModel.updateUser(updatedUser)
                    viewModel.saveUser(updatedUser)
                    onNavigateToMain()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить профиль")
        }
    }
}