package com.horoscope.mini.data.repository

import com.horoscope.mini.data.local.HoroscopeDao
import com.horoscope.mini.domain.model.HoroscopeItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HoroscopeRepository @Inject constructor(
    private val horoscopeDao: HoroscopeDao
) {
    fun getAllHoroscopes(): Flow<List<HoroscopeItem>> {
        return horoscopeDao.getAllHoroscopes()
    }

    suspend fun insertHoroscopes(items: List<HoroscopeItem>) {
        horoscopeDao.insertAll(items)
    }
}