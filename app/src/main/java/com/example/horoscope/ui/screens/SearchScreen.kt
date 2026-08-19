package com.example.horoscope.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(onSignSelected: (String) -> Unit) {
    val signs = listOf("Овен","Телец","Близнецы","Рак","Лев","Дева","Весы","Скорпион","Стрелец","Козерог","Водолей","Рыбы")
    
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(signs) { sign ->
            Text(
                text = sign,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clickable { onSignSelected(sign) }
            )
        }
    }
}