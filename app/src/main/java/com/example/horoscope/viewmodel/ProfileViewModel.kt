package com.example.horoscope.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscope.data.local.User
import com.example.horoscope.data.repository.UserRepository
import com.example.horoscope.utils.getZodiacSign
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun saveUser(name: String, birthDate: String) {
        val parts = birthDate.split(".")
        val day = parts[0].toInt()
        val month = parts[1].toInt()
        val sign = getZodiacSign(day, month)

        val user = User(name = name, birthDate = birthDate, zodiacSign = sign)
        viewModelScope.launch {
            repository.saveUser(user)
        }
    }
}