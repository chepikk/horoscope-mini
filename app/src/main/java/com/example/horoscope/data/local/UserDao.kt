package com.example.horoscope.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): Flow<User?>          // ← теперь возвращает Flow, а не suspend

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}