package com.example.horoscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.horoscope.ui.theme.HoroscopeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoroscopeTheme {
                // Здесь будет навигация (пока заглушка)
                androidx.compose.material3.Text(text = "Horoscope App")
            }
        }
    }
}