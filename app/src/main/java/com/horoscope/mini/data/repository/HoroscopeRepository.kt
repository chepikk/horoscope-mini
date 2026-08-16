package com.horoscope.mini.data.repository

import com.horoscope.mini.data.local.dao.HoroscopeDao
import com.horoscope.mini.data.local.entity.HoroscopeEntity
import kotlinx.coroutines.flow.Flow

class HoroscopeRepository(private val horoscopeDao: HoroscopeDao) {

    fun getHoroscope(sign: String): Flow<HoroscopeEntity?> {
        return horoscopeDao.getHoroscope(sign)
    }

    suspend fun insertHoroscope(horoscope: HoroscopeEntity) {
        horoscopeDao.insertHoroscope(horoscope)
    }

    fun getAllHoroscopes(): Flow<List<HoroscopeEntity>> {
        return horoscopeDao.getAllHoroscopes()
    }
}