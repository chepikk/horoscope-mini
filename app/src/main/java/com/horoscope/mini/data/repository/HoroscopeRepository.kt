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
    fun getHoroscope(sign: String): Flow<HoroscopeItem?> {
        return horoscopeDao.getHoroscope(sign)
    }

    suspend fun insertHoroscope(item: HoroscopeItem) {
        horoscopeDao.insertHoroscope(item)
    }
}