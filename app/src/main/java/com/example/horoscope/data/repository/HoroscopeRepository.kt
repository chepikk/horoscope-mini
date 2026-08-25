cat > app/src/main/java/com/example/horoscope/data/repository/HoroscopeRepository.kt << 'EOF'
package com.example.horoscope.data.repository

import com.example.horoscope.data.local.HoroscopeDao
import com.example.horoscope.data.local.HoroscopeItem
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

    suspend fun getHoroscopeBySign(sign: String): HoroscopeItem? {
        return horoscopeDao.getHoroscopeBySign(sign)
    }

    suspend fun insertAll(items: List<HoroscopeItem>) {
        horoscopeDao.insertAll(items)
    }
}
EOF