package com.example.horoscope.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscope.data.local.User
import com.example.horoscope.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val user: StateFlow<User?> = userRepository.getUser()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun updateUser(newUser: User) {
        viewModelScope.launch {
            userRepository.saveUser(newUser)
        }
    }

    fun saveUser(userToSave: User) {
        viewModelScope.launch {
            userRepository.saveUser(userToSave)
        }
    }
}