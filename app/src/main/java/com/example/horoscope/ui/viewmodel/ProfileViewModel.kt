package com.example.horoscope.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscope.data.local.User
import com.example.horoscope.data.local.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {

    private val _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user.asStateFlow()

    init {
        viewModelScope.launch {
            userDao.getUser()?.let {
                _user.value = it
            }
        }
    }

    fun updateUser(newUser: User) {
        _user.value = newUser
    }

    fun saveUser(userToSave: User) {
        viewModelScope.launch {
            userDao.insertUser(userToSave)
        }
    }
}