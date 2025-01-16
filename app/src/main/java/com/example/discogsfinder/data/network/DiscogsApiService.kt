package com.example.discogsfinder.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Headers
import retrofit2.Call


// Модель музыкального релиза
data class MusicRelease(
    val id: Int,
    val title: String,
    val year: Int?,
    val thumb: String?
)

interface DiscogsApiService {
    @Headers(
        "User-Agent: DiscogsFinderApp/1.0",
        "Authorization: Discogs key=GOToRtCcaLyKIlUveiHf, secret=lesbzimeuHuoplrnhLNeTYPsinKbWuYl"
    )
    @GET("database/search")
    fun searchReleases(
        @Query("q") query: String,
        @Query("type") type: String = "release",
        @Query("token") token: String = "GOToRtCcaLyKIlUveiHf"
    ): Call<DiscogsResponse>
}
