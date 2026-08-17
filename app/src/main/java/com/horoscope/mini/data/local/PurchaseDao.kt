package com.horoscope.mini.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PurchaseDao {
    @Query("SELECT * FROM purchases WHERE productId = :productId LIMIT 1")
    suspend fun getPurchase(productId: String): Purchase?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPurchase(purchase: Purchase)
}