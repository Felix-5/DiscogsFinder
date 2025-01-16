package com.example.discogsfinder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MusicReleaseEntity::class], version = 1, exportSchema = false) // <-- ДОБАВЬ exportSchema = false
abstract class AppDatabase : RoomDatabase() {
    abstract fun releaseDao(): ReleaseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "discogs_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
