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

    suspend fun getHoroscope(sign: String): HoroscopeItem? {
        return horoscopeDao.getHoroscope(sign)
    }

    suspend fun insertHoroscope(item: HoroscopeItem) {
        horoscopeDao.insertHoroscope(item)
    }

    suspend fun insertHoroscopes(items: List<HoroscopeItem>) {
        horoscopeDao.insertHoroscopes(items)
    }
}