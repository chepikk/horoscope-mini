package com.example.horoscope.di

import android.content.Context
import androidx.room.Room
import com.example.horoscope.data.local.AppDatabase
import com.example.horoscope.data.local.UserDao
import com.example.horoscope.data.local.HoroscopeDao
import com.example.horoscope.data.repository.UserRepository
import com.example.horoscope.data.repository.HoroscopeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "horoscope_db").build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideHoroscopeDao(db: AppDatabase): HoroscopeDao = db.horoscopeDao()

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)

    @Provides
    @Singleton
    fun provideHoroscopeRepository(
        dao: HoroscopeDao,
        @ApplicationContext context: Context
    ): HoroscopeRepository = HoroscopeRepository(dao, context)
}