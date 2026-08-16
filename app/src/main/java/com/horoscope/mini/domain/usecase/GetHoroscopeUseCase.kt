package com.horoscope.mini.domain.usecase

import com.horoscope.mini.data.repository.HoroscopeRepository
import com.horoscope.mini.domain.model.HoroscopeItem
import javax.inject.Inject

class GetHoroscopeUseCase @Inject constructor(
    private val repository: HoroscopeRepository
) {
    suspend operator fun invoke(sign: String): HoroscopeItem? {
        return repository.getHoroscope(sign)
    }
}