package com.horoscope.mini.data.repository

import com.horoscope.mini.data.local.HoroscopeDao
import com.horoscope.mini.data.local.HoroscopeEntity

class HoroscopeRepository(
    private val horoscopeDao: HoroscopeDao
) {
    suspend fun getAllHoroscopes(): List<HoroscopeEntity> {
        return horoscopeDao.getAllHoroscopes()
    }

    suspend fun saveHoroscopes(horoscopes: List<HoroscopeEntity>) {
        horoscopeDao.clearAll()
        horoscopeDao.insertAll(horoscopes)
    }
}