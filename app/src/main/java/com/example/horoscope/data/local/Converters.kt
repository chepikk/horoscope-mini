package com.example.horoscope.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromMap(value: Map<String, String>?): String = Gson().toJson(value)

    @TypeConverter
    fun toMap(value: String): Map<String, String> =
        Gson().fromJson(value, object : TypeToken<Map<String, String>>() {}.type)
}