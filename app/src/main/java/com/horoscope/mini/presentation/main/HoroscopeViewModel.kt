package com.horoscope.mini.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horoscope.mini.domain.usecase.GetHoroscopeUseCase
import com.horoscope.mini.data.local.entity.HoroscopeEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(
    private val getHoroscopeUseCase: GetHoroscopeUseCase
) : ViewModel() {

    private val _horoscope = MutableStateFlow<HoroscopeEntity?>(null)
    val horoscope: StateFlow<HoroscopeEntity?> = _horoscope

    fun loadHoroscope(sign: String) {
        viewModelScope.launch {
            getHoroscopeUseCase(sign).collect { result ->
                _horoscope.value = result
            }
        }
    }
}