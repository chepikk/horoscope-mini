package com.horoscope.mini.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horoscope.mini.data.repository.HoroscopeRepository
import com.horoscope.mini.domain.model.HoroscopeItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(
    private val repository: HoroscopeRepository
) : ViewModel() {

    private val _horoscopes = MutableStateFlow<List<HoroscopeItem>>(emptyList())
    val horoscopes: StateFlow<List<HoroscopeItem>> = _horoscopes

    init {
        loadHoroscopes()
    }

    private fun loadHoroscopes() {
        viewModelScope.launch {
            _horoscopes.value = repository.getAllHoroscopes()
        }
    }
}