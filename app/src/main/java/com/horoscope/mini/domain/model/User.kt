package com.horoscope.mini.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int = 0,
    val name: String = "",
    val birthDate: String = "",
    val birthTime: String = "",
    val birthPlace: String = ""
)