package com.horoscope.mini.presentation.horoscope

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horoscope.mini.data.repository.HoroscopeRepository
import com.horoscope.mini.domain.model.HoroscopeItem
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

    fun loadInitialData(items: List<HoroscopeItem>) {
        viewModelScope.launch {
            if (horoscopes.value.isEmpty()) {
                repository.insertHoroscopes(items)
            }
        }
    }
}