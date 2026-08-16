package com.horoscope.mini.di

import android.content.Context
import androidx.room.Room
import com.horoscope.mini.data.local.AppDatabase
import com.horoscope.mini.data.local.dao.HoroscopeDao
import com.horoscope.mini.data.local.dao.PurchaseDao
import com.horoscope.mini.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "horoscope_database"
        ).build()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideHoroscopeDao(db: AppDatabase): HoroscopeDao = db.horoscopeDao()

    @Provides
    fun providePurchaseDao(db: AppDatabase): PurchaseDao = db.purchaseDao()
}