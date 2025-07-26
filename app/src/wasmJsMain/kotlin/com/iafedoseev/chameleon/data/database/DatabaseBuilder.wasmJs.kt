package com.iafedoseev.chameleon.data.database

import androidx.room.Room
import androidx.room.RoomDatabase

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    return Room.databaseBuilder<AppDatabase>(
        name = "chameleon_database.db",
    )
}