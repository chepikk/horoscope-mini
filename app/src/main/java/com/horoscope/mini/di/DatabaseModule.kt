package com.horoscope.mini.di

import com.horoscope.mini.data.local.AppDatabase
import com.horoscope.mini.data.local.HoroscopeDao
import com.horoscope.mini.data.local.PurchaseDao
import com.horoscope.mini.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    @Singleton
    fun provideHoroscopeDao(database: AppDatabase): HoroscopeDao = database.horoscopeDao()

    @Provides
    @Singleton
    fun providePurchaseDao(database: AppDatabase): PurchaseDao = database.purchaseDao()
}