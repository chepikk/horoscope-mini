package com.horoscope.mini.domain.usecase

import com.horoscope.mini.data.repository.HoroscopeRepository
import com.horoscope.mini.data.local.entity.HoroscopeEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHoroscopeUseCase @Inject constructor(
    private val repository: HoroscopeRepository
) {
    operator fun invoke(sign: String): Flow<HoroscopeEntity?> {
        return repository.getHoroscope(sign)
    }
}