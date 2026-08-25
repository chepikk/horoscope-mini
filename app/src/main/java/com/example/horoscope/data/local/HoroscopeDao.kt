package com.example.horoscope.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HoroscopeDao {

    @Query("SELECT * FROM horoscopes")
    fun getAllHoroscopes(): Flow<List<HoroscopeItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<HoroscopeItem>)

    @Query("SELECT * FROM horoscopes WHERE `Знак зодиака` = :zodiacSign AND period = :period LIMIT 1")
    suspend fun getHoroscopeBySignAndPeriod(zodiacSign: String, period: String): HoroscopeItem?
}