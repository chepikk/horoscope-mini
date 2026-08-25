package com.example.horoscope.ui.viewmodel
suspend fun getHoroscope(sign: String, period: String): HoroscopeItem? {
    return horoscopeDao.getHoroscope(sign, period)
}
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscope.data.local.HoroscopeItem
import com.example.horoscope.data.repository.HoroscopeRepository
import com.example.horoscope.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainHoroscopeViewModel @Inject constructor(
    private val horoscopeRepository: HoroscopeRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _horoscope = MutableStateFlow<HoroscopeItem?>(null)
    val horoscope: StateFlow<HoroscopeItem?> = _horoscope.asStateFlow()

    private var currentZodiac: String = ""

    init {
        viewModelScope.launch {
            userRepository.getUser().collect { user ->
                user?.zodiacSign?.let {
                    currentZodiac = it
                    loadHoroscope(0)
                }
            }
        }
    }

    fun loadHoroscope(tabIndex: Int) {
        if (currentZodiac.isBlank()) return

        val period = when (tabIndex) {
            0 -> "today"
            1 -> "tomorrow"
            2 -> "week"
            else -> "today"
        }

        viewModelScope.launch {
            _horoscope.value = horoscopeRepository.getHoroscope(currentZodiac, period)
        }
    }
}