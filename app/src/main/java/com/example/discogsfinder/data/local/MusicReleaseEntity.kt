package com.example.discogsfinder.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "releases")
data class MusicReleaseEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val year: Int?,
    val thumb: String?
)
