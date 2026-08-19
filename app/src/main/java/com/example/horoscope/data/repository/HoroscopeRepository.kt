package com.example.horoscope.data.repository

import android.content.Context
import com.example.horoscope.data.local.HoroscopeDao
import com.example.horoscope.data.local.HoroscopeItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HoroscopeRepository @Inject constructor(
    private val dao: HoroscopeDao,
    private val context: Context
) {
    fun getHoroscope(sign: String, date: String): Flow<HoroscopeItem?> =
        dao.getHoroscope(sign, date)

    suspend fun loadHoroscopesFromJson() {
        val json = context.assets.open("horoscopes.json").bufferedReader().use { it.readText() }
        val list = Gson().fromJson<List<HoroscopeItem>>(json, object : TypeToken<List<HoroscopeItem>>() {}.type)
        dao.insertAll(list)
    }
}