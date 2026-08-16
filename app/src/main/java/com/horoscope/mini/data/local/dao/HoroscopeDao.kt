package com.horoscope.mini.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.horoscope.mini.data.local.entity.HoroscopeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HoroscopeDao {
    @Query("SELECT * FROM horoscopes WHERE sign = :sign")
    fun getHoroscope(sign: String): Flow<HoroscopeEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHoroscope(horoscope: HoroscopeEntity)

    @Query("SELECT * FROM horoscopes")
    fun getAllHoroscopes(): Flow<List<HoroscopeEntity>>
}