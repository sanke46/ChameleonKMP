package com.iafedoseev.chameleon.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.mp.KoinPlatform.getKoin

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val appContext = getKoin().get<android.content.Context>()
    val dbFile = appContext.getDatabasePath("chameleon_database.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}