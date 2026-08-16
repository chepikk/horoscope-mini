package com.horoscope.mini.di

import com.horoscope.mini.data.repository.HoroscopeRepository
import com.horoscope.mini.data.local.dao.HoroscopeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHoroscopeRepository(dao: HoroscopeDao): HoroscopeRepository {
        return HoroscopeRepository(dao)
    }
}