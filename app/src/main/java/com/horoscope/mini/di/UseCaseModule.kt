package com.horoscope.mini.di

import com.horoscope.mini.data.repository.HoroscopeRepository
import com.horoscope.mini.domain.usecase.GetHoroscopeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetHoroscopeUseCase(
        repository: HoroscopeRepository
    ): GetHoroscopeUseCase {
        return GetHoroscopeUseCase(repository)
    }
}