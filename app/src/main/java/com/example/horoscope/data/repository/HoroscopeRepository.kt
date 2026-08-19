package com.example.horoscope.data.repository

import android.content.Context
import com.example.horoscope.data.local.HoroscopeDao
import com.example.horoscope.data.local.HoroscopeItem
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HoroscopeRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val horoscopeDao: HoroscopeDao
) {
    fun getAllHoroscopes(): Flow<List<HoroscopeItem>> {
        return horoscopeDao.getAllHoroscopes()
    }

    suspend fun insertHoroscopes(items: List<HoroscopeItem>) {
        horoscopeDao.insertAll(items)
    }
}