package com.example.horoscope.di

import android.content.Context
import androidx.room.Room
import com.example.horoscope.data.local.AppDatabase
import com.example.horoscope.data.local.HoroscopeDao
import com.example.horoscope.data.local.UserDao
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
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "horoscope_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideHoroscopeDao(database: AppDatabase): HoroscopeDao {
        return database.horoscopeDao()
    }
}