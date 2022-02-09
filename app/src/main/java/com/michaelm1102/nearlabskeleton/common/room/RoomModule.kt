package com.michaelm1102.nearlabskeleton.common.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): NearDatabase {
        return Room.databaseBuilder(context, NearDatabase::class.java, NearDatabase.DatabaseName)
            .fallbackToDestructiveMigration().build()
    }
}