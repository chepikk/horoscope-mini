package com.horoscope.mini.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.horoscope.mini.domain.model.HoroscopeItem
import kotlinx.coroutines.flow.Flow

@Dao
interface HoroscopeDao {
    @Query("SELECT * FROM horoscope_items")
    fun getAllHoroscopes(): Flow<List<HoroscopeItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<HoroscopeItem>)
}