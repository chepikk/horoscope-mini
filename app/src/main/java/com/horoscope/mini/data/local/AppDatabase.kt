package com.horoscope.mini.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.horoscope.mini.domain.model.HoroscopeItem

@Database(entities = [HoroscopeItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun horoscopeDao(): HoroscopeDao
}