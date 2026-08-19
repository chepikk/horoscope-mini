package com.example.horoscope.data.repository

import com.example.horoscope.data.local.User
import com.example.horoscope.data.local.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    fun getUser(): Flow<User?> = userDao.getUser()

    suspend fun saveUser(user: User) {
        userDao.insertUser(user)
    }
}