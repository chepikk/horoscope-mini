package com.example.horoscope.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horoscopes")
data class HoroscopeItem(
    @PrimaryKey val id: Int = 0,
    val sign: String,
    val date: String,
    val text: String,
    val emoji: String,
    val advice: String,
    val compatibility: Map<String, String> = emptyMap()
)