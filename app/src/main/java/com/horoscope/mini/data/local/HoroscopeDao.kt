package com.horoscope.mini.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HoroscopeDao {
    @Query("SELECT * FROM horoscopes")
    suspend fun getAllHoroscopes(): List<HoroscopeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(horoscopes: List<HoroscopeEntity>)

    @Query("DELETE FROM horoscopes")
    suspend fun clearAll()
}