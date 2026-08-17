package com.horoscope.mini.presentation.natal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class NatalChartUiState(
    val birthDate: String = "",
    val birthTime: String = "",
    val birthCity: String = "",
    val isLoading: Boolean = false,
    val result: String? = null,
    val error: String? = null
)

@HiltViewModel
class NatalChartViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(NatalChartUiState())
    val uiState = _uiState.asStateFlow()

    fun onBirthDateChange(date: String) {
        _uiState.update { it.copy(birthDate = date, error = null) }
    }

    fun onBirthTimeChange(time: String) {
        _uiState.update { it.copy(birthTime = time, error = null) }
    }

    fun onBirthCityChange(city: String) {
        _uiState.update { it.copy(birthCity = city, error = null) }
    }

    fun calculateNatalChart() {
        val state = _uiState.value

        if (state.birthDate.isBlank() || state.birthTime.isBlank() || state.birthCity.isBlank()) {
            _uiState.update { it.copy(error = "Заполните все поля") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null, result = null) }

            // Заглушка расчёта (позже заменим на реальную логику)
            kotlinx.coroutines.delay(800)
            val resultText = "Натальная карта рассчитана для ${state.birthDate} в ${state.birthCity}"

            _uiState.update {
                it.copy(
                    isLoading = false,
                    result = resultText
                )
            }
        }
    }
}