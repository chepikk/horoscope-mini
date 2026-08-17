package com.horoscope.mini.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horoscopes")
data class HoroscopeItem(
    @PrimaryKey val sign: String,
    val today: String,
    val week: String,
    val month: String
)