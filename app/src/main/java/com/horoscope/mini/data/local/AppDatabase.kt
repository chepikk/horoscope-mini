package com.horoscope.mini.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.horoscope.mini.domain.model.HoroscopeItem
import com.horoscope.mini.domain.model.User

@Database(
    entities = [User::class, HoroscopeItem::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun horoscopeDao(): HoroscopeDao
    abstract fun purchaseDao(): PurchaseDao
}