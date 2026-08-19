package com.example.horoscope.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscope.data.local.HoroscopeItem
import com.example.horoscope.data.repository.HoroscopeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(
    private val repository: HoroscopeRepository
) : ViewModel() {

    val horoscopes: StateFlow<List<HoroscopeItem>> = repository.getAllHoroscopes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun loadHoroscopes(items: List<HoroscopeItem>) {
        viewModelScope.launch {
            repository.insertHoroscopes(items)
        }
    }
}