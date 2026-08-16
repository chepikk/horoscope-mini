package com.horoscope.mini.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.horoscope.mini.data.local.dao.HoroscopeDao
import com.horoscope.mini.data.local.dao.PurchaseDao
import com.horoscope.mini.data.local.dao.UserDao
import com.horoscope.mini.data.local.entity.HoroscopeEntity
import com.horoscope.mini.data.local.entity.PurchaseEntity
import com.horoscope.mini.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        HoroscopeEntity::class,
        PurchaseEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun horoscopeDao(): HoroscopeDao
    abstract fun purchaseDao(): PurchaseDao
}