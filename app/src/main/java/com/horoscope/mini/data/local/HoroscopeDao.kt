package com.horoscope.mini.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.horoscope.mini.domain.model.HoroscopeItem
import kotlinx.coroutines.flow.Flow

@Dao
interface HoroscopeDao {

    @Query("SELECT * FROM horoscopes")
    fun getAllHoroscopes(): Flow<List<HoroscopeItem>>

    @Query("SELECT * FROM horoscopes WHERE sign = :sign LIMIT 1")
    suspend fun getHoroscope(sign: String): HoroscopeItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHoroscope(item: HoroscopeItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHoroscopes(items: List<HoroscopeItem>)
}