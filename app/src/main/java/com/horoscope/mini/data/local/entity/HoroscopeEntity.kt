package com.horoscope.mini.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horoscopes")
data class HoroscopeEntity(
    @PrimaryKey val sign: String,
    val date: String,
    val text: String,
    val compatibility: String
)