package com.example.horoscope.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.horoscope.data.local.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {
    private val _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user

    fun updateUser(newUser: User) {
        _user.value = newUser
    }
}