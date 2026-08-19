package com.example.horoscope.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HoroscopeDao {
    @Query("SELECT * FROM horoscopes WHERE sign = :sign AND date = :date")
    fun getHoroscope(sign: String, date: String): Flow<HoroscopeItem?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<HoroscopeItem>)
}