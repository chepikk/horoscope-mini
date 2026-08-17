package com.horoscope.mini.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchases")
data class Purchase(
    @PrimaryKey val productId: String,
    val isPurchased: Boolean = false
)