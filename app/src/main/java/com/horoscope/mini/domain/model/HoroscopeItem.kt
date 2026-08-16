package com.horoscope.mini.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horoscope_items")
data class HoroscopeItem(
    @PrimaryKey val sign: String,
    val date: String,
    val prediction: String,
    val love: String,
    val career: String,
    val health: String
)