package com.horoscope.mini.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horoscopes")
data class HoroscopeEntity(
    @PrimaryKey val sign: String,
    val text: String,
    val date: String
)