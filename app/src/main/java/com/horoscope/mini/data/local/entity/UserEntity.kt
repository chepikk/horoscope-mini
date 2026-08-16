package com.horoscope.mini.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String?,
    val birthDate: String?,
    val birthTime: String?,
    val birthPlace: String?,
    val zodiacSign: String?
)