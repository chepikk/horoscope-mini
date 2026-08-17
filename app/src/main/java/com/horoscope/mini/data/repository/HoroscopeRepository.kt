package com.horoscope.mini.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.horoscope.mini.data.local.HoroscopeDao
import com.horoscope.mini.domain.model.HoroscopeItem
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HoroscopeRepository @Inject constructor(
    private val horoscopeDao: HoroscopeDao,
    @ApplicationContext private val context: Context
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

    suspend fun loadInitialDataIfNeeded() {
        if (horoscopeDao.getCount() == 0) {
            val json = context.assets.open("horoscopes.json").bufferedReader().use { it.readText() }
            val listType = object : TypeToken<List<HoroscopeItem>>() {}.type
            val items: List<HoroscopeItem> = Gson().fromJson(json, listType)
            horoscopeDao.insertHoroscopes(items)
        }
    }
}