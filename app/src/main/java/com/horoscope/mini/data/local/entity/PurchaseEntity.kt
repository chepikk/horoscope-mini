package com.horoscope.mini.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchases")
data class PurchaseEntity(
    @PrimaryKey val productId: String,
    val purchaseTime: Long,
    val isAcknowledged: Boolean
)