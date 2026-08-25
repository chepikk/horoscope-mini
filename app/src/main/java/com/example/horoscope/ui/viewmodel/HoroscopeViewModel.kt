package com.example.horoscope.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscope.data.local.HoroscopeItem
import com.example.horoscope.data.repository.HoroscopeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(
    private val repository: HoroscopeRepository
) : ViewModel() {

    private val _horoscope = MutableStateFlow<HoroscopeItem?>(null)
    val horoscope: StateFlow<HoroscopeItem?> = _horoscope

    fun loadHoroscope(sign: String, date: String) {
        viewModelScope.launch {
            repository.getHoroscope(sign, date).collect {
                _horoscope.value = it
            }
        }
    }

    fun loadInitialData() {
        viewModelScope.launch {
            repository.loadHoroscopesFromJson()
        }
    }
}