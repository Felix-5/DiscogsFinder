package com.example.discogsfinder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReleaseDao {
    @Insert
    suspend fun saveRelease(release: MusicReleaseEntity)

    @Query("SELECT * FROM releases")
    suspend fun getAllReleases(): List<MusicReleaseEntity>
}
